/*新增子流程增发功能 默认为不允许*/
alter table cnaec_processdefinition add additional number default 0;

/*更新当前库脚本编号*/
 update ws_sys set par_value='116', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
