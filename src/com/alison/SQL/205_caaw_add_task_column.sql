/*���������ֶ� ������������ģ����*/
alter table caaw_task add xml_Node_Id varchar2(1024);
alter table caaw_task add xml_Parent_Node_Id varchar2(1024);
alter table caaw_task add plane_id varchar2(1024);
alter table caaw_task_type add task_type_category varchar2(32) default '00';

/*���µ�ǰ��ű����*/
 update ws_sys set par_value='205', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';

commit;
