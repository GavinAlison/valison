--增加在线文档标记

alter table WS_DOC_CATE add mark varchar2(1024);


update ws_sys set par_value='145', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;