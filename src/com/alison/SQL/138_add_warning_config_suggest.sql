/*����������ϱ��е�������*/
alter table  warning_config add suggest varchar2(4000);
/*���µ�ǰ��ű����*/
 update ws_sys set par_value='138', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
