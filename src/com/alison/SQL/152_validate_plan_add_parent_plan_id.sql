/*计划表添加父计划标识*/
alter table CAAW_VALIDATE_PLAN add parent_id number;
alter table CAAW_VALIDATE_PLAN add plan_grade  varchar2(32);
alter table Caaw_Validate_Plan add subsystem_name varchar2(1024);
alter table Caaw_Validate_Plan add plan_number varchar2(1024);


/*
alter table CAAW_VALIDATE_PLAN add parent  number;
update caaw_validate_plan t  set t.parent=t.parent_id;
alter table CAAW_VALIDATE_PLAN drop column parent_id;
alter table CAAW_VALIDATE_PLAN rename column parent to parent_id;

*/


