/*����Ƕ�ױ���ܲ���*/
alter table cnaec_task_children_process add nesting_table_gather_param varchar2(1024);
/*�ڽڵ��������Ƿ���Ƕ�ױ����*/
alter table cnaec_transition add do_nesting_table_gather number default 0;
/*Ƕ�ױ����ʹ�õ������еı��� ��Ҫִ������sql��alter table ws_report_input_desc_Ƕ�ױ�id add origin_child_process varchar2(1024);*/


/*���µ�ǰ��ű����*/
 update ws_sys set par_value='86', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
