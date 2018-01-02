  /**
  ���ڽ�����һά������ͬ����������Ķ�ά���̱���
  
  
  ע��:
  1��ȷ�����ݿ����Դ��ڴ�����CreateNewProcessReportV2
  2��ȷ�����ö�ά�� ws_v2_rec_char_pro_��id ws_v2_rec_app_pro_��id
  �粻���� �������̹����е������ά����sql�� ������ִ��sql��ʹ�ñ��洢����
  3��Ҫ��ͬһ�������е��漰�������б�ִ�б��洢����
  
  
  ִ��ʱ���贫���id ,
  �� plsql developer�� ִ��341�ű������ͬ��
  
  begin
    pro1topro2(341);
  end;
  /
  commit;
  
  ����commit���ύ���񣬿����ִ��
  */
  create or replace procedure pro1topro2(tableid in varchar2) is
  --һά���α�
  cursor pro_cursor is
    select input_id from ws_input_desc where rep_table_id = tableid;
  cursor dataitem_cursor is
    select dataitem_id, dataitem_rec
      from ws_dataitem di
      join ws_domain d
        on di.domain_id = d.domain_id
     where d.rep_table_id = tableid;
  --��ά��̬�α�
  TYPE ref_cursor_type is REF cursor;
  usrs       ref_cursor_type;
  infos      ref_cursor_type;
  rec        ref_cursor_type;
  v_sql      varchar2(4000);
  v_input_id ws_input_desc.input_id%type;
  v_t_count  number;
  v_diid     ws_dataitem.dataitem_id%type;
  v_drec     ws_dataitem.dataitem_rec%type;
begin
  dbms_output.put_line(tableid);
  open pro_cursor;
  loop
    fetch pro_cursor
      into v_input_id;
    exit when pro_cursor%notfound;
    v_sql := 'select count(1) from ws_V2_input_desc where input_id=' ||
             v_input_id || ' and rep_table_id=' || tableid;
    open usrs for v_sql;
    loop
      fetch usrs
        into v_t_count;
      exit when usrs%notfound;
      if v_t_count = 0 then
        --�������������Ϣ��
        dbms_output.put_line(v_t_count + 1);
        v_sql := 'insert into ws_v2_input_desc(input_id,org_code,rep_table_id,common_orderby,common_remark,common_author_id,common_author_name,common_create_time,common_modifyer_name,common_modify_time,common_display,common_extend_1,common_extend_2,common_data_scope_id,common_record_status,common_year_on,common_month_on,input_date,input_date_str,input_user,input_processinstance,input_processdefinition,input_finish_flag,input_cancel,input_warn,input_parant,input_save_flag,input_imp_date,cur_tdid,former_tdid,input_block)' ||
                 'select input_id,org_code,rep_table_id,common_orderby,common_remark,common_author_id,common_author_name,common_create_time,common_modifyer_name,common_modify_time,common_display,common_extend_1,common_extend_2,common_data_scope_id,common_record_status,common_year_on,common_month_on,input_date,input_date_str,input_user,input_processinstance,input_processdefinition,input_finish_flag,input_cancel,input_warn,input_parant,input_save_flag,input_imp_date,cur_tdid,former_tdid,input_block from ws_input_desc where input_id=' ||
                 v_input_id || ' and rep_table_id=' || tableid;
        --dbms_output.put_line(v_sql);
        execute immediate v_sql;
      
        v_sql := 'select count(1) from ws_v2_rec_char_pro_' || tableid ||
                 ' where input_id=' || v_input_id;
        open infos for v_sql;
        loop
          fetch infos
            into v_t_count;
          exit when infos%notfound;
          if v_t_count = 0 then
            --�������(������)
            dbms_output.put_line(v_t_count + 1);
            v_sql := 'insert into ws_v2_rec_char_pro_' || tableid ||
                     '(input_id,common_orderby,common_remark,common_author_id,common_author_name,common_modifyer_name,common_modify_time,common_display,common_extend_1,common_extend_2,common_data_scope_id,common_record_status,common_year_on,common_month_on)' ||
                     'select input_id,common_orderby,common_remark,common_author_id,common_author_name,common_modifyer_name,common_modify_time,common_display,common_extend_1,common_extend_2,common_data_scope_id,common_record_status,common_year_on,common_month_on from ws_input_desc where input_id=' ||
                     v_input_id;
            --dbms_output.put_line(v_sql);
            execute immediate v_sql;
          end if;
        end loop;
        close infos;
        --�����������²���
        open dataitem_cursor;
        loop
          fetch dataitem_cursor
            into v_diid, v_drec;
          exit when dataitem_cursor%notfound;
          v_sql := 'update ws_v2_rec_char_pro_' || tableid || ' set d' ||
                   v_diid ||
                   '=(select rec_char_content from ws_rec_char_process_' ||
                   tableid || ' where input_id=' || v_input_id ||
                   ' and dataitem_id=' || v_diid || ')' ||
                   ' where input_id=' || v_input_id;
          --dbms_output.put_line(v_sql);
          execute immediate v_sql;
          if v_drec = 3 then
            v_sql := 'select rec_app_id from ws_rec_appendix_process_' ||
                     tableid || ' where input_id=' || v_input_id ||
                     ' and dataitem_id=' || v_diid;
                     --||' and rec_app_content is not null';
            open rec for v_sql;
            loop
              fetch rec
                into v_t_count;
              exit when rec%notfound;
              if v_t_count > 0 then
            
              --�������(����)
              -- dbms_output.put_line(v_t_count + 1);
              v_sql := 'insert into ws_v2_rec_app_pro_' || tableid ||
                       '(rec_app_id,input_id,dataitem_id,rec_app_content,rec_app_value,rec_app_desc,common_orderby,common_remark,common_author_id,common_author_name,common_modifyer_name,common_modify_time,common_display,common_extend_1,common_extend_2,common_data_scope_id,common_record_status,common_year_on,common_month_on,data_group_id)' ||
                       'select rec_app_id,input_id,dataitem_id,rec_app_content,rec_app_value,rec_app_desc,common_orderby,common_remark,common_author_id,common_author_name,common_modifyer_name,common_modify_time,common_display,common_extend_1,common_extend_2,common_data_scope_id,common_record_status,common_year_on,common_month_on,data_group_id from ws_rec_appendix_process_' ||
                       tableid || ' where input_id=' || v_input_id ||
                       ' and dataitem_id=' || v_diid||'and rec_app_id='||v_t_count;
              --dbms_output.put_line(v_sql);
              execute immediate v_sql;
              end if;
            end loop;
            close rec;
          end if;
        end loop;
        close dataitem_cursor;
      end if;
    end loop;
    close usrs;
  end loop;
  close pro_cursor;

end pro1topro2;
