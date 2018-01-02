create or replace view ws_module_user as
select mg.module_id,
gu.user_id,
 MAX(mgs.DATA_SCOPE) AS DATA_SCOPE,
       MAX(mgs.QUERYING) QUERYING,
       MAX(mgs.CREATING) CREATING,
       MAX(mgs.MODIFYING) MODIFYING,
       MAX(mgs.CONTROLLING) CONTROLLING,
       MAX(mgs.PRINTING) PRINTING,
       MAX(mgs.EXPORTING) EXPORTING
 from ws_module_user_group mg inner join ws_module_role_ext mgs on mg.id=mgs.module_group_id inner join ws_group_user gu on
mg.group_id=gu.group_id group by user_id,module_id;


/*更新当前库脚本编号*/
 update ws_sys set par_value='112', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
   commit;
