/*ws_user表中添加备用扩展字段common_extend_3到common_extend_7
 *commonExtend3;//表示新建用户是否设置过密级 0未设置  1已设置
 *commonExtend4;//表示新建用户是否设置过商密 0未设置  1已设置
*/
alter table ws_user add(common_extend_3 varchar2(1024),common_extend_4 varchar2(1024),common_extend_5 varchar2(1024),common_extend_6 varchar2(1024),common_extend_7 varchar2(1024));
update ws_sys set par_value='218', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') where par_name='DB_VERSION';
commit;
