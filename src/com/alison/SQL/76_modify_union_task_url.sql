/*�޸�ͳһ������е�url����*/
alter table ws_union_task  modify url varchar2(4000);

/*���µ�ǰ��ű����*/
 update ws_sys set par_value='76', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
