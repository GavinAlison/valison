/**����Ԥ��������ʾ**/
alter table warning_config add data_prompt varchar2(4000);
/*���µ�ǰ��ű����*/
 update ws_sys set par_value='133', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
