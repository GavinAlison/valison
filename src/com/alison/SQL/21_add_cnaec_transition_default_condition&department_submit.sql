/**��������Ĭ���ύ����**/
alter table cnaec_transition add default_condition  varchar(1024);
/**�������ύ**/
alter table cnaec_transition add department_submit varchar(100);
/**�޸ľ����� Ĭ�ϲ��ǲ������ύ**/
update cnaec_transition t set t.department_submit='��' where t.department_submit is null;
commit;

/**˵����ִ�����sql֮����Ҫ���·������� �ù��ܲ���ʹ��**/