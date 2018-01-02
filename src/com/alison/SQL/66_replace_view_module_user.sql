create or replace view ws_module_user as
select mg.module_id,
gu.group_id,
gu.user_id,
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
mg.common_month_on,
mgs.querying,
mgs.creating,
mgs.modifying,
mgs.controlling,
mgs.printing,
mgs.exporting,
mgs.data_scope
 from ws_module_user_group mg inner join ws_module_role_ext mgs on mg.id=mgs.module_group_id inner join ws_group_user gu on
mg.group_id=gu.group_id;

drop view v_module_group_auth ;
