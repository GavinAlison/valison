/**交互系统加系统开关，贴子列表是否有统计功能**/

delete from ws_sys where par_name='PF_ATTACH_SIZE'; 
insert into ws_sys (par_name,par_value,par_desc)values('PF_ATTACH_SIZE','100','单次上传文件大小限制,正整数，单位为M');

/**交互系统加系统开关，首页贴子列表每个区域显示条数**/
delete from ws_sys where par_name='PF_FIRST_SHOW_COUNT'; 
insert into ws_sys (par_name,par_value,par_desc)values('PF_FIRST_SHOW_COUNT','8','首页每个区域显示条数,正整数');
