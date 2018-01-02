/*新增会签相关字段*/
alter table cnaec_task_children_process add pass_ratio number(3,2);
alter table cnaec_task_children_process add is_countersign number;
alter table cnaec_task_children_process add countersign_param varchar2(1024);
