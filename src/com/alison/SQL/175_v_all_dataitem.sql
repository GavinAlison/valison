-- add DATAITEM_NAME_ENG,DOMAIN_DESC_ENG ,REP_TABLE_NAME_ENG
create or replace view v_all_dataitem as
select "ROWNUM","DATAITEM_ID","DOMAIN_ID","EXCEL_INPUT_WIDTH","UNI_CODE","WS__DATAITEM_ID","DATAITEM_IF_ID","COMMON_ORDERBY","COMMON_REMARK","COMMON_AUTHOR_ID","COMMON_AUTHOR_NAME","COMMON_CREATE_TIME","COMMON_MODIFYER_NAME","COMMON_MODIFIER_ID","COMMON_MODIFY_TIME","COMMON_DISPLAY","COMMON_EXTEND_1","COMMON_EXTEND_2","COMMON_DATA_SCOPE_ID","COMMON_RECORD_STATUS","COMMON_YEAR_ON","COMMON_MONTH_ON","DATAITEM_NAME","DATAITEM_NAME_ENG","DATAITEM_DEFAULT","ONXXX","ONBLUR","ONCLICK","ONFOCUS","ONLOAD","DATAITEM_REC","DATAITEM_WARN","DATAITEM_SQL","DATAITEM_FUNCTION","DATAITEM_FLAG","ONKEYPRESS","DATAITEM_ONSHOW","DATAITEM_ONCHANGE","DATAITEM_ONFOCUS","DATAITEM_CODE","ORG_CODE","COMMON_MODIFY_ID","ALT","ONCHANGE","CHILD_REPORT_LIST","READ_ONLY","DOMAIN_DESC","DOMAIN_DESC_ENG","DOMAIN_WORK_ID","DSL_ID","STYLE_ID","ENUM_ID","TOP","LEFT","WIDTH","HEIGHT","SHOW","DIVLINE","DIS","REP_TYPE_ID","REP_TABLE_NAME","REP_TABLE_NAME_ENG","REP_TABLE_DESC","REP_TABLE_STAT","REP_TABLE_ID","RTSL_ID","CHILD_URL","SHARE_CHILD_PARAM" from(
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
