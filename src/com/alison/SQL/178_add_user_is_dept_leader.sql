alter table ws_user add is_dept_leader varchar2(32);
update ws_sys set par_value='178', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;