/* 增加用户的字体大小 */
alter table ws_user_theme add (user_font varchar2(1024));

 update ws_sys set par_value='88', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
   commit;