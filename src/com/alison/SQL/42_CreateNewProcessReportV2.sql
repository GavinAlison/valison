/**二维流程触发器**/
create or replace trigger CreateNewProcessReportV2
  after insert on WS_V2_INPUT_DESC
  for each row
declare
  cursor cnr_cursor is
  select di.dataitem_id ,di.dataitem_rec,di.dataitem_default
  from ws_dataitem di
  join ws_domain d on di.domain_id = d.domain_id
  where d.rep_table_id = :new.rep_table_id;
  v_did ws_dataitem.dataitem_id%type;
  v_rec ws_dataitem.dataitem_rec%type;
  v_def ws_dataitem.dataitem_default%type;
  createCharTab varchar2(4000);
  sql_stat      varchar2(4000);
  integrity_error  exception;
  errno            integer;
  errmsg           char(200);
  common_year varchar2(200);
  common_month varchar2(200);
begin
  select to_char(sysdate,'yyyy') into common_year from dual;
  select to_char(sysdate,'mm') into common_month from dual;
 
 createCharTab :='insert into WS_V2_REC_CHAR_PRO_'||:new.rep_table_id||'
 (input_id,common_year_on,common_month_on) values 
 ('||:new.input_id||','||common_year||','||common_month||')'; 
  execute immediate createCharTab;
  open cnr_cursor;
  loop
      fetch cnr_cursor into v_did,v_rec,v_def;
      exit when cnr_cursor%notfound;
      if v_rec = 2 then
         sql_stat :='update WS_V2_REC_CHAR_PRO_'||:new.rep_table_id||' set D'||v_did|| '='''||v_def||'''where input_id='|| :new.input_id;
         execute immediate sql_stat;
      end if;
      if v_rec = 3 then
         sql_stat :='insert into WS_V2_REC_APP_PRO_'||:new.rep_table_id||'(rec_app_id,dataitem_id,input_id) values(SEQ_APP.NEXTVAL,'||v_did||','||:new.input_id||')';
         execute immediate sql_stat;
      end if;
  end loop;
  close cnr_cursor;
exception
    when integrity_error then
       raise_application_error(errno, errmsg);
end CreateNewProcessReportV2;
