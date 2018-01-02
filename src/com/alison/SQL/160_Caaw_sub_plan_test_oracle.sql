/** 子系统计划文件关系表 */
/** drop and create table */
drop table caaw_sub_plan_test cascade constraints;
create table caaw_sub_plan_test (
  ID                NUMBER not null, /** pk */
  VERSION           NUMBER not null,
  ORDERBY           VARCHAR2(1024),
  REMARK            VARCHAR2(1024),
  HISTORY           CLOB,
  AUTHOR_ID         NUMBER,
  AUTHOR_NAME       VARCHAR2(1024),
  AUTHOR_TIME       DATE,
  MODIFYER_ID       NUMBER,
  MODIFYER_NAME     VARCHAR2(1024),
  MODIFY_TIME       DATE,
  DATA_SCOPE_ID     NUMBER default 0,
  RECORD_STATUS     NUMBER default 0,
  DISPLAY           NUMBER default 0,
  EXTEND_1          VARCHAR2(1024),
  EXTEND_2          VARCHAR2(1024),
  SHEET_ACCESSORIES VARCHAR2(4000),
  
  --表个性化字段：
  PLAN_ID VARCHAR2(32),
  TEST_ID VARCHAR2(32),
  constraint PK_CAAW_SUB_PLAN_TEST primary key (ID)
);

/** create sequence */
drop sequence SEQ_CAAW_SUB_PLAN_TEST;
create sequence SEQ_CAAW_SUB_PLAN_TEST
start with 1
increment by 1
nominvalue
nomaxvalue
nocache;

/** create view */
/**
CREATE or REPLACE view V_CAAW_SUB_PLAN_TEST as
SELECT * FROM caaw_sub_plan_test 
*/

--create synonym for avicit user : apps
--create or replace synonym CAAW_SUB_PLAN_TEST for caaw.CAAW_SUB_PLAN_TEST;
