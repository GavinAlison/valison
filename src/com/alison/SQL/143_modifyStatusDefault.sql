--��common_record_statusĬ��ֵ��Ϊ1
--0ΪԤ��ʧЧ��1ΪԤ����Ч
alter table  warning_config modify common_record_status default 1;
--�����е���Ϊ��Ч
update warning_config t set t.common_record_status=1;
/*���µ�ǰ��ű����*/
update ws_sys set par_value='143', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;
