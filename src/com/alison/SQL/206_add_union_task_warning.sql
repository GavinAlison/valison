/*ͳһ��������Ԥ���ֶ�warning*/
alter table ws_union_task add warning varchar2(1024);
/*��������ģ��id*/
alter table caaw_task add module_id varchar2(32);

/*���µ�ǰ��ű����*/
 update ws_sys set par_value='206', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';

commit;
