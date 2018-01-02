/*·ÏÆú see 77_update_uni_code.sql*/
/*¸øÎ¨Ò»±àÂë¸³Öµ*/
update CNAEC_PROCESSDEFINITION t set t.uni_code = 'pdid'||t.pd_id where t.uni_code is null;
update CNAEC_TASKDEFINITION t set t.uni_code = 'tdid'||t.td_id where t.uni_code is null;
update WS_REP_TABLE t set t.uni_code='rept'||t.rep_table_id where t.uni_code is null;
update ws_domain t set t.uni_code='do'||t.domain_id where t.uni_code is null;
update ws_dataitem t set t.uni_code = 'da'||t.dataitem_id where t.uni_code is null;
update ws_enum t set t.uni_code = 'enum'||t.enum_id where t.uni_code is null;
update ws_enum_value t set t.uni_code='enumV'||t.enumvalue_id where t.uni_code is null;
commit;
