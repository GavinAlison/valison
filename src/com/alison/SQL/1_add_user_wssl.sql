/*密级分为人员密级和数据密级两种显示名称*/
alter table ws_sl add user_sl_name varchar2(100);
/*处理历史数据*/
update ws_sl w set w.user_sl_name=w.sl_name;
