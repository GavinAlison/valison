alter table ws_doc_info add info_version varchar2(1024);
alter table ws_manage_doc_info add info_version varchar2(1024);

/*更新当前库脚本编号*/
 update ws_sys set par_value='114', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
