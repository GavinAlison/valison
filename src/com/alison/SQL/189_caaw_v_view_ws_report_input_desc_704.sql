create or replace view ws_report_input_desc_704 as 
select c.input_id             as input_id,
       c.d2886                as d3568, /*条款号*/
       c.d2890                as d3572, /*条款名称*/
       t.mc                   as d3574, /*符合性方法*/
       c.d2878                as d3562, /*项目id*/
       c.d2880                as d3564, /*型别*/
       t.cp_id                as d3566, /*cpId*/
       c.d2884                as d3570, /*条款id*/
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
  from ws_report_input_desc_588 c
  left join (select a.d2882 as cp_id,
                    a.d2884 as clause_id,
                    zh_concat(distinct t.mc) as mc
               from ws_report_input_desc_588 a
               left join caaw_subsys_mc t
                 on a.d2884 = t.clause_id
                and a.d2882 = t.cp_id
              group by a.d2882, a.d2884) t
    on t.clause_id = c.d2884
   and t.cp_id = c.d2882;

/*更新当前库脚本编号*/
 update ws_sys set par_value='189', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;
