/*��ws_user_work����Ϊ��ͼ�����bug:��ɫ������û�֮�󣬶�Ӧ��ɫ��Ȩ��û��ͬ�����û���*/
drop table ws_user_work;
create or replace view ws_user_work as
select mg.td_id,
mgs.user_id,
mg.common_orderby,
mg.common_remark,
mg.common_author_id,
mg.common_author_name,
mg.common_create_time,
mg.common_modifier_id,
mg.common_modifyer_name,
mg.common_modify_time,
mg.common_display,
mg.common_extend_1,
mg.common_extend_2,
mg.common_data_scope_id,
mg.common_record_status,
mg.common_year_on,
mg.common_month_on
 from ws_group_work mg inner join ws_group_user mgs on mg.group_id=mgs.group_id;
 
 /*���µ�ǰ��ű����*/
 update ws_sys set par_value='106', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
