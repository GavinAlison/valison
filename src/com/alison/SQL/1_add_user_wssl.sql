/*�ܼ���Ϊ��Ա�ܼ��������ܼ�������ʾ����*/
alter table ws_sl add user_sl_name varchar2(100);
/*������ʷ����*/
update ws_sl w set w.user_sl_name=w.sl_name;
