/*ws_sl里添加数据项password_complexity（密码字符种类）,password_diff（修改时密码区别位数）, password_length（密码长度）, password_change_period（密码修改周期）*/
alter table ws_sl add (password_complexity varchar2(100),password_diff varchar2(100),password_length  varchar2(100),password_change_period varchar2(100));

/*更新当前库脚本编号*/
 update ws_sys set par_value='208', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';

commit;