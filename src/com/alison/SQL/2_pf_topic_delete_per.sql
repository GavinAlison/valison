/**��ϵͳ���أ����������˵�ɾ�����ܺ���Ϣ���ķ�ҳ����**/

delete from ws_sys where par_name='TOPIC_DELETE' or par_name='REPLY_DELETE' or par_name='TOP_PAGE';
insert into ws_sys (par_name,par_value,par_desc)values('TOPIC_DELETE','no','�����˿�ɾ������');
insert into ws_sys (par_name,par_value,par_desc)values('REPLY_DELETE','no','�����˿�ɾ���ظ�');
insert into ws_sys (par_name,par_value,par_desc)values('TOP_PAGE','yes','��Ϣ�������з�ҳ');
