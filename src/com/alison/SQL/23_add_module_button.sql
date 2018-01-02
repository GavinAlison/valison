/**在WS_MODULE加字段MODULE_ICON，记录模块图标*/
alter table WS_MODULE add module_icon varchar2(1024);




/**加按钮式顶层模块配置，如不添加默认是原来的树型模块*/
insert into ws_sys (par_name,par_value,par_desc)values('INDEX_PAGE_URL','UserHomepageAction.do','门户式登录页面URL');
