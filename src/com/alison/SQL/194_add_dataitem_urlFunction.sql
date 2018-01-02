/*数据项加属性：链接函数*/
alter table ws_dataitem add urlFunction varchar2(1024);

create or replace view v_all_dataitem as
select "ROWNUM","DATAITEM_ID","DOMAIN_ID","EXCEL_INPUT_WIDTH","UNI_CODE","WS__DATAITEM_ID","DATAITEM_IF_ID","COMMON_ORDERBY","COMMON_REMARK","COMMON_AUTHOR_ID","COMMON_AUTHOR_NAME","COMMON_CREATE_TIME","COMMON_MODIFYER_NAME","COMMON_MODIFIER_ID","COMMON_MODIFY_TIME","COMMON_DISPLAY","COMMON_EXTEND_1","COMMON_EXTEND_2","COMMON_DATA_SCOPE_ID","COMMON_RECORD_STATUS","COMMON_YEAR_ON","COMMON_MONTH_ON","DATAITEM_NAME","DATAITEM_NAME_ENG","DATAITEM_DEFAULT","ONXXX","ONBLUR","ONCLICK","ONFOCUS","ONLOAD","DATAITEM_REC","DATAITEM_WARN","DATAITEM_SQL","DATAITEM_FUNCTION","DATAITEM_FLAG","ONKEYPRESS","DATAITEM_ONSHOW","DATAITEM_ONCHANGE","DATAITEM_ONFOCUS","DATAITEM_CODE","ORG_CODE","COMMON_MODIFY_ID","ALT","ONCHANGE","CHILD_REPORT_LIST","READ_ONLY","DOMAIN_DESC","DOMAIN_DESC_ENG","DOMAIN_WORK_ID","DSL_ID","STYLE_ID","ENUM_ID","TOP","LEFT","WIDTH","HEIGHT","SHOW","DIVLINE","DIS","REP_TYPE_ID","REP_TABLE_NAME","REP_TABLE_NAME_ENG","REP_TABLE_DESC","REP_TABLE_STAT","REP_TABLE_ID","RTSL_ID","CHILD_URL","SHARE_CHILD_PARAM" ,"URLFUNCTION" from(
select rownum,di.*,d.domain_desc,d.domain_desc_eng ,d.domain_work_id,d.sl_id as dsl_id
,t.style_id,t.enum_id,t.top,t.left,t.width,t.height,t.show,t.divline,t.dis
,rt.rep_type_id,rt.rep_table_name,rt.rep_table_name_eng,rt.rep_table_desc,rt.rep_table_stat,rt.rep_table_id,rt.sl_id as rtsl_id
from ws_dataitem di
left join ws_domain d
on di.domain_id = d.domain_id
left join ws_template t
on di.dataitem_id = t.dataitem_id
left join ws_rep_table rt
on d.rep_table_id = rt.rep_table_id
);

create or replace view v_all_pur_dataitem as
select dv."ROWNUM",dv."DATAITEM_ID",dv."EXCEL_INPUT_WIDTH",dv."UNI_CODE",dv."DOMAIN_ID",dv."WS__DATAITEM_ID",dv."DATAITEM_IF_ID",dv."COMMON_ORDERBY",dv."COMMON_REMARK",dv."COMMON_AUTHOR_ID",dv."COMMON_AUTHOR_NAME",dv."COMMON_CREATE_TIME",dv."COMMON_MODIFYER_NAME",dv."COMMON_MODIFIER_ID",dv."COMMON_MODIFY_TIME",dv."COMMON_DISPLAY",dv."COMMON_EXTEND_1",dv."COMMON_EXTEND_2",dv."COMMON_DATA_SCOPE_ID",dv."COMMON_RECORD_STATUS",dv."COMMON_YEAR_ON",dv."COMMON_MONTH_ON",dv."DATAITEM_NAME",dv."DATAITEM_NAME_ENG",dv."DATAITEM_DEFAULT",dv."ONXXX",dv."ONBLUR",dv."ONCLICK",dv."ONFOCUS",dv."ONLOAD",dv."DATAITEM_REC",dv."DATAITEM_WARN",dv."DATAITEM_SQL",dv."DATAITEM_FUNCTION",dv."DATAITEM_FLAG",dv."ONKEYPRESS",dv."DATAITEM_ONSHOW",dv."DATAITEM_ONCHANGE",dv."DATAITEM_ONFOCUS",dv."DATAITEM_CODE",dv."ORG_CODE",dv."COMMON_MODIFY_ID",dv."ALT",dv."ONCHANGE",dv."CHILD_REPORT_LIST",dv."CHILD_URL",DV."SHARE_CHILD_PARAM",DV."READ_ONLY",dv."DOMAIN_DESC",dv."DOMAIN_DESC_ENG",dv."DOMAIN_WORK_ID",dv."DSL_ID",dv."STYLE_ID",dv."ENUM_ID",dv."TOP",dv."LEFT",dv."WIDTH",dv."HEIGHT",dv."SHOW",dv."DIVLINE",dv."DIS",dv."REP_TYPE_ID",dv."REP_TABLE_NAME",dv."REP_TABLE_NAME_ENG",dv."REP_TABLE_DESC",dv."REP_TABLE_STAT",dv."REP_TABLE_ID",dv."RTSL_ID",dv."DSLDESC",dv."TSLDESC",uv.user_id,dv."URLFUNCTION" from(
select v.*,ds.sl_desc as dsldesc,ts.sl_desc as tsldesc from v_all_dataitem v
left join ws_sl ds on ds.sl_id=v.DSL_ID
left join ws_sl ts on ts.sl_id = v.RTSL_ID
) dv,(select * from ws_user u left join ws_sl s on u.sl_id=s.sl_id) uv
where dv.tsldesc >= uv.sl_desc and dv.dsldesc>=uv.sl_desc;

update ws_sys set par_value='194', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;
