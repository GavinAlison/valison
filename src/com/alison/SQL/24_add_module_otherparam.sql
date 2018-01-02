/**增加字段other_param，用于记录不拼接在链接上的其他参数**/
alter table ws_module  add other_param varchar2(1024);
