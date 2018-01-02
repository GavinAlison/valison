alter table cnaec_transition add SUBMIT_DATE_ITEM varchar2(1024);

 update ws_sys set par_value='100', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;
