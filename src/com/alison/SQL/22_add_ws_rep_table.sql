/**在WS_REP_TABLE表里加字段DATA_SL_ID，记录密级数据项ID*/
alter table WS_REP_TABLE add data_sl_id varchar2(1024);




/**修改密级数据项的点击事件*/
update  Ws_Dataitem set onclick='showWsSlByTableValue(this,''ws_sl'',''sl_name'');'
where dataitem_name='密级';

update Ws_dataitem d set onblur='hideEnum(this);' where d.dataitem_name='密级';
