/*���������ֶΣ�Ԥ����������������*/
alter table caaw_task add warn_days varchar2(32);
alter table caaw_task add task_model_type varchar2(32);

update caaw_task t set t.task_model_type='00';

/*�������Ͷ��������module_id*/
alter table caaw_task_type add task_type_module_id varchar(32);

/*���µ�ǰ��ű����*/
 update ws_sys set par_value='204', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';

commit;
