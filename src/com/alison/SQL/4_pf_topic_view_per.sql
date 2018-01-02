/**加系统开关，贴子列表是否有统计功能**/

delete from ws_sys where par_name='TOPIC_VIEW'; 
insert into ws_sys (par_name,par_value,par_desc)values('TOPIC_VIEW','yes','列表贴子显示查看数字');


