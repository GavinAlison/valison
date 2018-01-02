/*去除“岗位”概念 删除相关数据和结构*/
delete from ws_module_user_group t where t.module_id=(select m.module_id from ws_module m where m.module_url='PostListAction.do');
delete from ws_module t where t.module_url = 'PostListAction.do';
alter table ws_user  drop column post_id;
drop table ws_post_auth;
drop table ws_post;



