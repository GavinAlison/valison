alter table WS_DOC_ATTACHMENT add ATTACH_FILE_SIZE varchar2(4000);
alter table WS_MANAGE_DOC_ATTACHMENT add ATTACH_FILE_SIZE varchar2(4000);

/*更新当前库脚本编号*/
 update ws_sys set par_value='142', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';