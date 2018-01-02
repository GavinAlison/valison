/*添加只显示默认接收人开关 默认为关*/
alter table cnaec_taskdefinition add default_accept_user number default 0;

/*更新当前库脚本编号*/
 update ws_sys set par_value='78', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
