/*������ʷ����  ��ԭ�ȵľ������м�������Ϊ1*/
update caaw_validate_plan t set t.plan_grade=1 where t.plan_grade is null;
commit;
