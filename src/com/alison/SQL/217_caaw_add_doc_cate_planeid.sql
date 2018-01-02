/*¹éµµÄ¿Â¼±íÌí¼Ó×Ö¶Î*/
alter table ws_doc_cate add project_id varchar2(32);
alter table ws_doc_cate add plane_id varchar2(32);

alter table ws_doc_info add project_id varchar2(32);
alter table ws_doc_info add plane_id varchar2(32);

alter table ws_doc_info add dataitem_id varchar2(200);
alter table ws_doc_info add url varchar2(200);

update ws_sys set par_value='217', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') where par_name='DB_VERSION';
commit;
