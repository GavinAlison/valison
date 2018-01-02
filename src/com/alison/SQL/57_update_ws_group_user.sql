/**处理旧数据 将用户组和用户的关系保存在ws_group_user表中 删掉ws_user表里面的group_id**/
insert into ws_group_user (id,group_id,user_id) select seq_group_user.nextVal,group_id,user_id from ws_user where group_id is not null;
--alter table Ws_user drop column group_id;
commit;
