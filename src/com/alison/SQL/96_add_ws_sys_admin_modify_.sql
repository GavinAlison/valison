/**����ϵͳ���� ����Ա��admin�ʻ����Ƿ����������ʵ���������޸ı�����(Ĭ��Ϊ��)**/
insert into ws_sys (par_name,par_value,par_desc)values('ADMIN_MODIFY','no','����Ա��admin�ʻ����Ƿ����������ʵ���������޸ı�����');
/*���µ�ǰ��ű����*/
 update ws_sys set par_value='96', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
