/*更新历史数据  将原先的旧数据中级别设置为1*/
update caaw_validate_plan t set t.plan_grade=1 where t.plan_grade is null;
commit;
