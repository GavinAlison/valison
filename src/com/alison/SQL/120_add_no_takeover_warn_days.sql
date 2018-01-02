/*节点上添加属性：未接手预警天数*/
alter table cnaec_taskdefinition add td_no_takeover_warn_days varchar2(1024);
/*统一待办添加moduleid*/
alter table ws_union_task add module_id varchar2(1024);

/*更新当前库脚本编号*/
 update ws_sys set par_value='120', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
