/**��������� ���û�����û��Ĺ�ϵ������ws_group_user���� ɾ��ws_user�������group_id**/
insert into ws_group_user (id,group_id,user_id) select seq_group_user.nextVal,group_id,user_id from ws_user where group_id is not null;
--alter table Ws_user drop column group_id;
commit;
