/*增加附件上传人id*/
declare 
cursor cur_sql is select 'alter table '||table_name||' add (attach_size number,user_id number(22),upload_time date,auditor number(22),audit_time date)' as delsql from user_tables 
where lower(table_name) like 'ws_v2_rec_app_pro_%';
begin 
for rec_sql in cur_sql loop
   -- dbms_output.put_line('开始删除'||rec_sql.delsql);
    execute immediate (rec_sql.delsql);
end loop;
end;
/*更新当前库脚本编号*/
 update ws_sys set par_value='97', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;