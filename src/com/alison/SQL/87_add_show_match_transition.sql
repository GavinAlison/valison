/*添加字段用来显示流程提交时是否只显示符合条件出口 默认为否*/
alter table cnaec_taskdefinition  add show_match_transition number default 0;

 update ws_sys set par_value='87', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
   commit;
