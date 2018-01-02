/* 按照固定格式给唯一编码赋值(处理旧数据) 
 */
update CNAEC_PROCESSDEFINITION t set t.uni_code =''||(select t.par_value from ws_sys t where t.par_name='ORG_NAME')|| '_p_'||t.pd_id;
update CNAEC_TASKDEFINITION t set t.uni_code = ''||(select t.par_value from ws_sys t where t.par_name='ORG_NAME')||'_pt_'||t.td_id;
update WS_REP_TABLE t set t.uni_code=''||(select t.par_value from ws_sys t where t.par_name='ORG_NAME')||'_t_'||t.rep_table_id ;
update ws_domain t set t.uni_code=''||(select t.par_value from ws_sys t where t.par_name='ORG_NAME')||'_td_'||t.domain_id ;
update ws_dataitem t set t.uni_code =''||(select t.par_value from ws_sys t where t.par_name='ORG_NAME')|| '_tdd_'||t.dataitem_id ;
update ws_enum t set t.uni_code = ''||(select t.par_value from ws_sys t where t.par_name='ORG_NAME')||'_e_'||t.enum_id ;
update ws_enum_value t set t.uni_code=''||(select t.par_value from ws_sys t where t.par_name='ORG_NAME')||'_ev_'||t.enumvalue_id ;
commit;

/*更新当前库脚本编号*/
 update ws_sys set par_value='77', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
   
