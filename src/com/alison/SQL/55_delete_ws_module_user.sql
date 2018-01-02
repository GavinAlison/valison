/*移除用户权限管理模块*/
drop table ws_module_user cascade constraints;
--delete from ws_module_user_group t where t.module_id=(select module_id from ws_module t where t.module_url like '%wsUser/WsUserAuthListAction.do%');
--delete from ws_module t where t.module_url like '%wsUser/WsUserAuthListAction.do%';
--commit;
