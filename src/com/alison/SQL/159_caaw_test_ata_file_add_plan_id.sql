/*试验清单 和条款 文件的关系表添加计划id*/
alter table caaw_test_ata add plan_id varchar2(32);
alter table caaw_test_file  add plan_id varchar2(32);
