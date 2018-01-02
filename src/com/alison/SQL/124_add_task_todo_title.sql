alter table CNAEC_TASKDEFINITION add TODO_TITLE varchar(4000);

/*更新当前库脚本编号*/
 update ws_sys set par_value='124', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';