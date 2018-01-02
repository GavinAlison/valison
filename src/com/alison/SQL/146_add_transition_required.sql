--节点出口添加必填项。
alter table CNAEC_TRANSITION add TRANSITION_REQUIRED varchar2(1024);


update ws_sys set par_value='146', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;