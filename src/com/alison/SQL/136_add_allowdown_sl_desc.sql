/**����ϵͳ���� �����������ص�����ܼ� Ĭ��Ϊ���� ���ڲ������ܵĸ������������� ֻ������ܼ��û��鿴**/
insert into ws_sys (par_name,par_value,par_desc)values('ATTACH_ALLOWDOWN_LOWEST_SL_DESC','3','�����������ص�����ܼ�');

/*���µ�ǰ��ű����*/
 update ws_sys set par_value='136', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
