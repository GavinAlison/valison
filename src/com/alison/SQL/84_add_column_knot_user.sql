/*系统自动发帖增加结贴人*/
alter table ws_v2_pftopicruleconfig add knot_user varchar2(200);


/*更新当前库脚本编号*/
 update ws_sys set par_value='84', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';

