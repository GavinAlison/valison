/*���̱�����ֶΣ��洢��ϸ��չ�ֵ���ʽ��Ĭ��Ϊ����*/
alter table cnaec_processdefinition add pro_detail_style number default 1;

/*���µ�ǰ��ű����*/
 update ws_sys set par_value='98', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION'; 
   commit
