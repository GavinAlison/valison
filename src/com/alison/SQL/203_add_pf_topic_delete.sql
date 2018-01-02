alter table pf_topic add Common_Deleted varchar2(1024);
alter table pf_topic add auto_delete_date varchar2(1024);

update ws_sys set par_value='203', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;