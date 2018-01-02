
/*流程表增加字段名 监控部门数据项ID*/
alter table cnaec_processdefinition add monitor_dept_dataitem_id varchar2(1024);
/*流程表增加字段名 监控超期变红天数 默认为15天*/
alter table cnaec_processdefinition add monitor_red_days number default 15;
/*流程表增加字段名 监控变红百分比 默认为70*/
alter table cnaec_processdefinition add monitor_red_percent number default 70;
/*节点表增加字段名 是否监控 默认为是*/
alter table cnaec_taskdefinition add is_monitor number default 1;

/*更新当前库脚本编号*/
update ws_sys set par_value='107', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
where par_name='DB_VERSION';
