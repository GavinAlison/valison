/*项目符合性检查清单视图*/
create or replace view v_project_check_shell as
SELECT 
       t.d2898 as projectId,
       t.d2900 as planeId,
       t.D2902   as clauseId,
       T.D3370   AS ruleTitle,
       T.D2904   as partNo,
       T.D2906   AS ruleIssue ,
       a.ata_id as ataId,
       a.ata     as ata,
       b.mc_id   as mcId,
       b.mc      as mc,
       c.file_id as fileId,
       d.d1334   as fileNumber,
       d.d1336   as fileVersion,
       d.d1338   as fileTitle,
       d.d2149   as designCharger,
       d.d1344   as caawCharger,
       d.d1348   as reviewRepresentative,
       d.d2159   as DER,
       d.d2165   as validationStatus,
       t.common_orderby,
       t.common_remark,
       t.common_author_id,
       t.common_author_name,
       t.common_modifyer_name,
       t.common_modify_time,
       t.common_display,
       t.common_extend_1,
       t.common_extend_2,
       t.common_data_scope_id,
       t.common_record_status,
       t.common_year_on,
       t.common_month_on,
       t.input_id
  from ws_report_input_desc_592 t left join ws_report_input_desc_588 m on t.d2902=m.D2894
  left join caaw_subsys_clause_ata a
    on m.d2884 = a.clause_id
  left join caaw_subsys_mc b
    on a.ata_id = b.ata_id
   and b.clause_id = m.d2884
  left join caaw_subsys_mc_file c
    on c.clause_id = m.d2884
   and c.ata_id = a.ata_id
   and c.mc_id = b.mc_id
  left join ws_report_input_desc_262 d
    on c.file_id = d.input_id;

/*更新当前库脚本编号*/
 update ws_sys set par_value='188', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;