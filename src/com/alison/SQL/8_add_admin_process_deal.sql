/**加系统开关，管理员有任意流程提交权限**/

delete from ws_sys where par_name='MANAGE_SUBMIT_PROCESS'; 
insert into ws_sys (par_name,par_value,par_desc)values('MANAGE_SUBMIT_PROCESS','yes','管理员有任意流程提交权限');

/*加系统打回功能开关，因对打回的理解有争议，所以有的厂所要求屏蔽*/

delete from ws_sys where par_name='PUT_BACK'; 
insert into ws_sys (par_name,par_value,par_desc)values('PUT_BACK','yes','流程表单上有打回按钮');
