/**EXT列表模块的显示列设置可个性化记在系统表内,在ws_user_personal表中添加table_id
来记录显示列信息属于哪个表**/
alter table ws_user_personal add(table_id varchar2(1024) );
update ws_sys set par_value='215', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') where par_name='DB_VERSION';
commit;
