/**����ϵͳ���� �������ϴ��ĸ����Ƿ���Ҫ��׺(Ĭ��Ϊ��)�Լ��Ƿ���Ҫ����(Ĭ��Ϊ��)**/
insert into ws_sys (par_name,par_value,par_desc)values('PF_ATTACH_SUFFIX','no','�������ϴ��ĸ����ڷ����������ϱ���ʱ�Ƿ��к�׺');
insert into ws_sys (par_name,par_value,par_desc)values('PF_ATTACH_ENCRYPT','yes','�������ϴ��ĸ����ڷ������������Ƿ���Ҫ����');

/*���µ�ǰ��ű����*/
 update ws_sys set par_value='89', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
