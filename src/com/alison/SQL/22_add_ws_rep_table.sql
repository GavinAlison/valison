/**��WS_REP_TABLE������ֶ�DATA_SL_ID����¼�ܼ�������ID*/
alter table WS_REP_TABLE add data_sl_id varchar2(1024);




/**�޸��ܼ�������ĵ���¼�*/
update  Ws_Dataitem set onclick='showWsSlByTableValue(this,''ws_sl'',''sl_name'');'
where dataitem_name='�ܼ�';

update Ws_dataitem d set onblur='hideEnum(this);' where d.dataitem_name='�ܼ�';
