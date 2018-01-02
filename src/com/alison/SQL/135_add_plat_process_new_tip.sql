/**系统开关 扁平化流程是否有流程更新提示**/
insert into ws_sys (par_name,par_value,par_desc)values('PLAT_PROCESS_NEW_TIP','yes','扁平化流程是否有流程更新提示');

/*更新当前库脚本编号*/
 update ws_sys set par_value='135', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
