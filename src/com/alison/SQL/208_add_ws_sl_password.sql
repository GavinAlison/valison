/*ws_sl�����������password_complexity�������ַ����ࣩ,password_diff���޸�ʱ��������λ����, password_length�����볤�ȣ�, password_change_period�������޸����ڣ�*/
alter table ws_sl add (password_complexity varchar2(100),password_diff varchar2(100),password_length  varchar2(100),password_change_period varchar2(100));

/*���µ�ǰ��ű����*/
 update ws_sys set par_value='208', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';

commit;