/*添加导出标识字段（军代局）*/
alter table ws_dataitem add export_flag varchar2(1024);
update ws_sys set par_value='191', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;