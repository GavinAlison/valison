--����\������Ϣ���ά��ˢ�´洢����������������Ϊ���ô洢����
-- create by lisen 
--�����������ִ��
--��iqs��Ϊ��������Ա�û�
grant create any view to iqs;

/**
��ά���̱�ˢ��
*/
create or replace procedure avicinfo_refresh_p2t(table_id in varchar2) is
  cursor dataitem_cursor is
    select di.dataitem_id, di.uni_code
      from ws_dataitem di
      left join ws_domain d
        on d.domain_id = di.domain_id
     where d.rep_table_id = table_id;
  v_t_count     number;
  v_column_name varchar2(200);
  v_diid        ws_dataitem.dataitem_id%type;
  v_uc          ws_dataitem.uni_code%type;
  v_sql         varchar2(4000);
  v_view_sql    varchar2(32767);
begin
  v_view_sql := '';
  open dataitem_cursor;
  loop
    fetch dataitem_cursor
      into v_diid, v_uc;
    exit when dataitem_cursor%notfound;
    v_column_name := 'D' || v_diid;
    select count(1)
      into v_t_count
      from user_Tab_Columns
     where table_name = 'WS_V2_REC_CHAR_PRO_' || table_id
       and column_name = v_column_name;
    v_view_sql := v_view_sql || ',D' || v_diid || ' as ' || v_uc;
    if v_t_count = 0 then
      --��Ӳ����ڵ��ֶ�
      execute immediate 'alter table WS_V2_REC_CHAR_PRO_' || table_Id ||
                        ' add ' || v_column_name || ' varchar2(4000)';
    end if;
  end loop;
  close dataitem_cursor;
  --��ӡ
  --avicinfo_put_line(v_view_sql);
  --������ͼ
  execute immediate 'create or replace view V_WS_V2_REC_CHAR_PRO_' ||
                    table_id ||
                    ' as select INPUT_ID,COMMON_ORDERBY,COMMON_REMARK,COMMON_AUTHOR_ID,COMMON_AUTHOR_NAME,COMMON_MODIFYER_NAME,COMMON_MODIFY_TIME,COMMON_DISPLAY,COMMON_EXTEND_1,COMMON_EXTEND_2,COMMON_DATA_SCOPE_ID,COMMON_RECORD_STATUS,COMMON_YEAR_ON,COMMON_MONTH_ON' ||
                    v_view_sql || ' from WS_V2_REC_CHAR_PRO_' || table_id;
end avicinfo_refresh_p2t;
/

/**
��ά����ˢ��
*/
create or replace procedure avicinfo_refresh_s2t(table_id in varchar2) is
  cursor dataitem_cursor is
    select di.dataitem_id, di.uni_code
      from ws_dataitem di
      left join ws_domain d
        on d.domain_id = di.domain_id
     where d.rep_table_id = table_id;
  v_t_count     number;
  v_column_name varchar2(200);
  v_diid        ws_dataitem.dataitem_id%type;
  v_uc          ws_dataitem.uni_code%type;
begin
  open dataitem_cursor;
  loop
    fetch dataitem_cursor
      into v_diid, v_uc;
    exit when dataitem_cursor%notfound;
    v_column_name := 'D' || v_diid;
    select count(1)
      into v_t_count
      from user_Tab_Columns
     where table_name = 'WS_REPORT_INPUT_DESC_' || table_id
       and column_name = v_column_name;
    if v_t_count = 0 then
      --��Ӳ����ڵ��ֶ�
      execute immediate 'alter table WS_REPORT_INPUT_DESC_' || table_Id ||
                        ' add ' || v_column_name || ' varchar2(4000)';
    end if;
  end loop;
  close dataitem_cursor;  
end avicinfo_refresh_s2t;
/



 update ws_sys set par_value='85', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
   commit;
   
--����ͬ��� ���ڽ𺽼���ƽ̨�����ݿ���ʹ�� ��apps�û���¼ִ��   
-- create or replace synonym avicinfo_refresh_p2t for iqs.avicinfo_refresh_p2t;
-- create or replace synonym avicinfo_refresh_s2t for iqs.avicinfo_refresh_s2t;