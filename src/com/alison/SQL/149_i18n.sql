--国际化
alter table ws_rep_table  add REP_TABLE_NAME_ENG VARCHAR2(1024);
alter table ws_domain add DOMAIN_DESC_ENG VARCHAR2(1024);
alter table ws_dataitem add DATAITEM_NAME_ENG VARCHAR2(1024);
alter table ws_module add MODULE_NAME_ENG VARCHAR2(1024);
alter table cnaec_taskdefinition add TD_NAME_ENG VARCHAR2(1024);
alter table cnaec_transition add T_NAME_ENG VARCHAR2(1024);
update ws_sys set par_value='149', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;
