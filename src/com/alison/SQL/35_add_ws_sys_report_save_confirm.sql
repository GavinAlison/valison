/**切换表单时需不需要保存当前表单(默认为需要)**/
insert into ws_sys (par_name,par_value,par_desc)values('REPORT_SAVE_CONFIRM','yes','在流程详细页面切换表单时需不需要保存当前表单');
/*修改值*/
update ws_sys t set t.par_value='no' where t.par_name='REPORT_SAVE_CONFIRM';