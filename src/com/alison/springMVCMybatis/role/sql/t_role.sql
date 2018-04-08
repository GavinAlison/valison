/** 角色 */
/** drop and create table */
drop table t_role cascade constraints;
create table t_role(
	ID NUMBER  not null ,/** pk */
	VERSION NUMBER not null,
	role_name varchar2(1024) not null,
	create_date varchar2(1024),
	note varchar2(1024) default null,
	constraint PK_T_ROLE primary key (ID)
);
/** create sequence */
drop sequence SEQ_T_ROLE;
create sequence SEQ_T_ROLE
start with 1
increment by 1
nominvalue 
nomaxvalue
nocache;


