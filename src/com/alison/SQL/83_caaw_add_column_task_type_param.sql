/*��caaw_task_type������������Ӳ���task_type_param*/
alter table caaw_task_type add task_type_param varchar2(4000);


/*���µ�ǰ��ű����*/
 update ws_sys set par_value='83', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';