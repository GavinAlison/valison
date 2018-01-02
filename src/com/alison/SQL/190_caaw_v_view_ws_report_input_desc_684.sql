create or replace view ws_report_input_desc_684 as 
select c.input_id             as input_id,
       r.part_no              as d3512, /*条款号*/
       r.rule_title           as d3514, /*条款名称*/
       t.mc                   as d3516, /*符合性方法*/
       c.d2878                as d3510, /*项目id*/
       c.d2880                as d3508, /*型别*/
       c.common_orderby       as common_orderby,
       c.common_remark        as common_remark,
       c.common_author_id     as common_author_id,
       c.common_author_name   as common_author_name,
       c.common_modifyer_name as common_modifyer_name,
       c.common_modify_time   as common_modify_time,
       c.common_display       as common_display,
       c.common_extend_1      as common_extend_1,
       c.common_extend_2      as common_extend_2,
       c.common_data_scope_id as common_data_scope_id,
       c.common_record_status as common_record_status,
       c.common_year_on       as common_year_on,
       c.common_month_on      as common_month_on
  from (select d.d2878 as project_id,
               d.d2894 as clause_id,
               zh_concat(distinct t.mc) as mc,
               max(input_id) as input_id
          from ws_report_input_desc_588 d
          left join caaw_subsys_mc t
            on t.cp_id = d.d2882
           and t.clause_id = d.d2884
         group by d.d2878, d.d2894) t
  left join caaw_rule r
    on t.clause_id = r.id
  left join ws_report_input_desc_588 c
    on c.input_id = t.input_id;


/*更新当前库脚本编号*/
 update ws_sys set par_value='190', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;
