alter table ws_log4j_log add log4j_reason varchar2(4000);
alter table ws_log4j_log add log4j_class varchar2(4000);

update ws_sys set par_value='198', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;