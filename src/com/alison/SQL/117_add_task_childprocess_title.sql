/*���ӽڵ������̴���ť��ʾ��������*/
alter table CNAEC_TASKDEFINITION add CHILD_PROCESS_DEAL_TITLE varchar2(1024);
alter table CNAEC_TASKDEFINITION add CHILD_PROCESS_VIEW_TITLE varchar2(1024);

/*���µ�ǰ��ű����*/
 update ws_sys set par_value='117', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
