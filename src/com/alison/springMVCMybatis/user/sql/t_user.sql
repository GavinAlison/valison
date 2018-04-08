/** 用户 */
/** drop and create table */
drop table t_user cascade constraints;
create table t_user(
	ID NUMBER  not null ,/** pk */
	VERSION NUMBER not null,
	user_name varchar2(1024) not null,
	birthday varchar2(1024),
	sex varchar2(10),
	mobile varchar2(20),
	email varchar2(60) default null,
	note varchar2(1024) default null,
	constraint PK_T_USER primary key (ID)
);
/** create sequence */
drop sequence SEQ_T_USER;
create sequence SEQ_T_USER
start with 1
increment by 1
nominvalue 
nomaxvalue
nocache;


