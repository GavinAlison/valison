/*将退回和退回编制人的权限分开*/
insert into ws_sys (par_name,par_value,par_desc)values('PUT_BACK_TO_FIRST','yes','流程表单上有退回编制人按钮');
/*更新当前库脚本编号*/
 update ws_sys set par_value='122', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';