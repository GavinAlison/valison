/**增加系统开关 管理员（admin帐户）是否可以在流程实例管理中修改表单内容(默认为否)**/
insert into ws_sys (par_name,par_value,par_desc)values('ADMIN_MODIFY','no','管理员（admin帐户）是否可以在流程实例管理中修改表单内容');
/*更新当前库脚本编号*/
 update ws_sys set par_value='96', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
