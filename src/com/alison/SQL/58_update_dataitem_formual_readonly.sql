/**���й�ʽ������������Ϊֻ��**/
update ws_dataitem t set t.read_only='readonly' where t.dataitem_formula is not null;
commit;