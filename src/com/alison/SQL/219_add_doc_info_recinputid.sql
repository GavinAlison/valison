/*文档表添加附件ID*/
alter table ws_doc_info add rec_input_id varchar2(200);
update ws_sys set par_value='219', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') where par_name='DB_VERSION';
commit;
