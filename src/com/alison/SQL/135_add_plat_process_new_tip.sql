/**ϵͳ���� ��ƽ�������Ƿ������̸�����ʾ**/
insert into ws_sys (par_name,par_value,par_desc)values('PLAT_PROCESS_NEW_TIP','yes','��ƽ�������Ƿ������̸�����ʾ');

/*���µ�ǰ��ű����*/
 update ws_sys set par_value='135', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
