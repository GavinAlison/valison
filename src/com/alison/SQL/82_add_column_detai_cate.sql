/*������������ֶ� �����洢��ϸ���� ��ʱֻ����֪ʶ��ı�*/
alter table ws_rep_table add detail_cate varchar2(2000);

/*���µ�ǰ��ű����*/
 update ws_sys set par_value='82', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';