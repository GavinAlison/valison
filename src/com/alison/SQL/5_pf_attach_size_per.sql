/**����ϵͳ��ϵͳ���أ������б��Ƿ���ͳ�ƹ���**/

delete from ws_sys where par_name='PF_ATTACH_SIZE'; 
insert into ws_sys (par_name,par_value,par_desc)values('PF_ATTACH_SIZE','100','�����ϴ��ļ���С����,����������λΪM');

/**����ϵͳ��ϵͳ���أ���ҳ�����б�ÿ��������ʾ����**/
delete from ws_sys where par_name='PF_FIRST_SHOW_COUNT'; 
insert into ws_sys (par_name,par_value,par_desc)values('PF_FIRST_SHOW_COUNT','8','��ҳÿ��������ʾ����,������');
