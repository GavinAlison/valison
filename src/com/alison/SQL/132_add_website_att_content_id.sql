/*��վ�����������id�ֶ�*/
alter table ws_attachment  add content_id varchar2(1024);
/*���µ�ǰ��ű����*/
update ws_sys set par_value='132', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
