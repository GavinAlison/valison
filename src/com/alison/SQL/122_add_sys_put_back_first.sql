/*���˻غ��˻ر����˵�Ȩ�޷ֿ�*/
insert into ws_sys (par_name,par_value,par_desc)values('PUT_BACK_TO_FIRST','yes','���̱������˻ر����˰�ť');
/*���µ�ǰ��ű����*/
 update ws_sys set par_value='122', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';