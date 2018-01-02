create table WS_UNION_TASK(
	UT_ID VARCHAR2(32) not null,
	APP_Id varchar2(50) not null,
	TASK_NAME varchar2(1000) not null,
	APPTASK_ID varchar2(200) not null,
	TASK_TYPE varchar2(300),
	APPSEND_UID varchar2(500),
	APPRECEIVE_UID varchar2(500) not null,
	SEND_TIME varchar2(19),
	END_TIME varchar2(19),
	URL varchar2(1000) not null,
	TASK_DESC varchar2(3000),
	PRIORITY_ID varchar2(1),
	constraint PK_WS_UNION_TASK primary key(UT_ID)
);
drop sequence SEQ_LOG_INPUT
;

create sequence SEQ_UNIONTASK
increment by 1
start with 1
 nominvalue
 nomaxvalue
;

insert into ws_sys (par_name,par_value,par_desc)values('APP_ID','1','系统集成时的本系统应用ID');
