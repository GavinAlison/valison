/*流程加字段 是否监控 默认为否 */
alter table cnaec_processdefinition  add is_monitor number default 0 ;

/*更新当前库脚本编号*/
 update ws_sys set par_value='109', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
