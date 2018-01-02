--使用视图确定用户与节点关系
drop table ws_user_work;

create or replace view ws_user_work as
select distinct p.td_id, u.user_id from ws_user u,ws_post_auth p 
where u.post_id=p.post_id;