/*������������������ Ĭ��Ϊ������*/
alter table cnaec_transition add additional number default 0;

/*���µ�ǰ��ű����*/
 update ws_sys set par_value='125', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
