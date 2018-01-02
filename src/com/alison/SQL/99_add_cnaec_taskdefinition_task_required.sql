alter table cnaec_taskdefinition  add TASK_REQUIRED varchar2(1024);

 update ws_sys set par_value='99', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;
