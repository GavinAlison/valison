/*�����̽ڵ���ӿ����ύ��ֱ���ύ���� 0Ϊ������ 1 Ϊ����*/
alter table cnaec_taskdefinition add quick_submit number;
alter table cnaec_taskdefinition add default_submit number;
/*��������� Ĭ��Ϊ������*/
update cnaec_taskdefinition t set t.quick_submit=0,t.default_submit=0;
