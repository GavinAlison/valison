create or replace view ws_report_input_desc_598 as
select

a.project_id as d3012,
a.plane_id as d3014,
a.clause_id as d3018,
b.part_no as d3020,
b.rule_issue as d3022,
b.rule_title as d3024,
c.d2908 as d3026,
d.user_realname as d3028,
c.d2910 as d3030,
e.user_realname as d3032,
c.d2914 as d3034,
c.d2920 as d3036,
c.d2918 as d3038,
c.d2922 as d3040,
b.part_no||'条款符合性说明报告' as d3482,
'MC0' as d3486,
(select zh_concat(cp) from (
select distinct m.d2672 as cp, t.d2894,t.d2878,t.d2880 from ws_report_input_desc_564 m left join  ws_report_input_desc_588  t on m.input_id=t.d2882 )h where h.d2894=a.clause_id and a.project_id=h.d2878 and a.plane_id=h.d2880) as d3490,
c.common_orderby as common_orderby,
c.common_remark as common_remark,
c.common_author_id as common_author_id,
c.common_author_name as common_author_name,
c.common_modifyer_name as common_modifyer_name,
c.common_modify_time as common_modify_time,
c.common_display as common_display,
c.common_extend_1 as common_extend_1,
c.common_extend_2 as common_extend_2,
c.common_data_scope_id as common_data_scope_id,
c.common_record_status as common_record_status,
c.common_year_on as common_year_on,
c.common_month_on as common_month_on,
'598' as rep_table_id,
c.input_id as input_id,
c.input_date as input_date,
c.input_date_str as input_date_str,
c.input_user as input_user,
c.input_processinstance as input_processinstance,
c.input_processdefinition as input_processdefinition,
c.input_finish_flag as input_finish_flag,
c.input_cancel as input_cancel,
c.input_warn as input_warn,
c.input_parant as input_parant,
c.input_save_flag as input_save_flag,
c.input_imp_date as input_imp_date

 from (select distinct
d2894 as clause_id,d2878 as project_id,d2880 as plane_id from ws_report_input_desc_588) a
left join caaw_rule b on a.clause_id=b.id
left join ws_report_input_desc_592 c on a.clause_id=c.d2902 and a.project_id=c.d2898 left join ws_user d on c.d2910=d.user_id left join ws_user e on  c.d2914=e.user_id;


/*更新当前库脚本编号*/
 update ws_sys set par_value='183', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;
