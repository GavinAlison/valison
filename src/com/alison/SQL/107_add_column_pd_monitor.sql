
/*���̱������ֶ��� ��ز���������ID*/
alter table cnaec_processdefinition add monitor_dept_dataitem_id varchar2(1024);
/*���̱������ֶ��� ��س��ڱ������ Ĭ��Ϊ15��*/
alter table cnaec_processdefinition add monitor_red_days number default 15;
/*���̱������ֶ��� ��ر��ٷֱ� Ĭ��Ϊ70*/
alter table cnaec_processdefinition add monitor_red_percent number default 70;
/*�ڵ�������ֶ��� �Ƿ��� Ĭ��Ϊ��*/
alter table cnaec_taskdefinition add is_monitor number default 1;

/*���µ�ǰ��ű����*/
update ws_sys set par_value='107', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
where par_name='DB_VERSION';
