----�����Զ���ű�ķ�������ֶ�
alter table ws_auto_number add classify_dataitem_id varchar2(1024);
alter table ws_auto_number add classify_dataitem_value varchar2(1024);

/*���µ�ǰ��ű����*/
 update ws_sys set par_value='210', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';

commit;
