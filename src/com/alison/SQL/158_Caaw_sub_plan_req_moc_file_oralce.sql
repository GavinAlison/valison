/** 子系统计划条款方法文件关系表 */
/** drop and create table */
drop table caaw_sub_plan_req_moc_file cascade constraints;
create table caaw_sub_plan_req_moc_file (
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
	REQUIREMENT_ID VARCHAR2(32),
	MOC_ID VARCHAR2(32),
	FILE_ID VARCHAR2(32),
	constraint PK_CAAW_SUB_PLAN_REQ_MOC_FILE primary key (ID)
);

/** create sequence */
drop sequence SEQ_CAAW_SUB_PLAN_REQ_MOC_FILE;
create sequence SEQ_CAAW_SUB_PLAN_REQ_MOC_FILE
start with 1
increment by 1
nominvalue
nomaxvalue
nocache;

/** create view */
/**
CREATE or REPLACE view V_CAAW_SUB_PLAN_REQ_MOC_FILE as
SELECT * FROM caaw_sub_plan_req_moc_file 
*/

--create synonym for avicit user : apps
--create or replace synonym CAAW_SUB_PLAN_REQ_MOC_FILE for caaw.CAAW_SUB_PLAN_REQ_MOC_FILE;
