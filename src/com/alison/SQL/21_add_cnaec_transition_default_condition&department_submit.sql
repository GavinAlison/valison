/**增加流程默认提交条件**/
alter table cnaec_transition add default_condition  varchar(1024);
/**部门内提交**/
alter table cnaec_transition add department_submit varchar(100);
/**修改旧数据 默认不是部门内提交**/
update cnaec_transition t set t.department_submit='否' where t.department_submit is null;
commit;

/**说明：执行完此sql之后需要重新发布流程 该功能才能使用**/