/*���̼��ֶ� �Ƿ��� Ĭ��Ϊ�� */
alter table cnaec_processdefinition  add is_monitor number default 0 ;

/*���µ�ǰ��ű����*/
 update ws_sys set par_value='109', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
