create or replace procedure d1tod2(tableid in varchar2) is
--一维表游标
cursor d1_cursor is
select input_id from ws_report_input_desc where rep_table_id =tableid
-- and input_id<630
;
cursor dataitem_cursor is
select dataitem_id
from ws_dataitem di
join ws_domain d on di.domain_id = d.domain_id
where d.rep_table_id =tableid;
--二维动态游标
TYPE ref_cursor_type is REF cursor;
usrs ref_cursor_type;
v_sql varchar2(4000);
v_input_id ws_report_input_desc.input_id%type;
v_t_count number;
v_diid ws_dataitem.dataitem_id%type;
begin
  dbms_output.put_line(tableid);
  open d1_cursor;
  loop
     fetch d1_cursor into v_input_id;
     exit when d1_cursor%notfound;
     v_sql:='select count(1) from ws_report_input_desc_'||tableid||' where input_id='||v_input_id;
     open usrs for v_sql;
          loop
               fetch usrs into v_t_count;
               exit when usrs%notfound;
               if v_t_count = 0 then
                 --插入操作
                  dbms_output.put_line(v_t_count+1);
                  v_sql :='insert into ws_report_input_desc_'||tableid||'(input_id,rep_table_id,common_author_id,common_author_name,common_modifyer_name,common_modify_time,input_date_str,input_user,parent_input_id)'
                  ||'select input_id,rep_table_id,common_author_id,common_author_name,common_modifyer_name,common_modify_time,input_date_str,input_user,parent_input_id from ws_report_input_desc where input_id='||v_input_id;
                  --dbms_output.put_line(v_sql);
                  execute immediate v_sql;
               end if;
               --对数据做更新操作
               open dataitem_cursor;
               loop
                    fetch dataitem_cursor into v_diid;
                    exit when dataitem_cursor%notfound;
                    v_sql:='update ws_report_input_desc_'||tableid||' set d'||v_diid||'=(select rec_char_content from ws_rec_char_'||tableid||' where input_id='||v_input_id||' and dataitem_id='||v_diid||')'
                    ||' where input_id='||v_input_id;
                    --dbms_output.put_line(v_sql);
                    execute immediate v_sql;
               end loop;
               close dataitem_cursor;
          end loop;
     close usrs;
  end loop;
  close d1_cursor;
end d1tod2;
