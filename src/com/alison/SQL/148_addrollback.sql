--流程节点 添加“退回时需清空数据项”字段
alter table cnaec_taskdefinition add ROLLBACK_DATAITEM VARCHAR2(4000);

update ws_sys set par_value='148', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;
