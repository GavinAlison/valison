/**��ϵͳ���أ�����Ա�����������ύȨ��**/

delete from ws_sys where par_name='MANAGE_SUBMIT_PROCESS'; 
insert into ws_sys (par_name,par_value,par_desc)values('MANAGE_SUBMIT_PROCESS','yes','����Ա�����������ύȨ��');

/*��ϵͳ��ع��ܿ��أ���Դ�ص���������飬�����еĳ���Ҫ������*/

delete from ws_sys where par_name='PUT_BACK'; 
insert into ws_sys (par_name,par_value,par_desc)values('PUT_BACK','yes','���̱����д�ذ�ť');
