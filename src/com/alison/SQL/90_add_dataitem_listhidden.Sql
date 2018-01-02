alter table ws_dataitem add list_hidden varchar2(10);


/*更新当前库脚本编号*/
 update ws_sys set par_value='90', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
