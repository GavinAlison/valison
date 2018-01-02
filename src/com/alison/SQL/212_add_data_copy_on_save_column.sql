alter table  cnaec_taskdefinition add(data_copy_on_save varchar2(4000));
update ws_sys set par_value='212', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;
