/*�����̱���ʶ�ֶ�,��Ϊ1,��Ϊ0,Ĭ��Ϊ��*/
alter table caaw_project_templet add mile_stone VARCHAR2(32) default 0;
alter table caaw_task add mile_stone VARCHAR2(32) default 0;

/*���µ�ǰ��ű����*/
 update ws_sys set par_value='79', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';