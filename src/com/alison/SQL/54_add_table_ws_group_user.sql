/**建表 用来保存用户组和用户的关系 注意将iqs修改为当前表空间名称*/
-- Create table
create table WS_GROUP_USER (
  ID                   NUMBER not null,
  GROUP_ID             NUMBER ,
  USER_ID              NUMBER not null,
  COMMON_ORDERBY       VARCHAR2(100),
  COMMON_REMARK        VARCHAR2(1024),
  COMMON_AUTHOR_ID     VARCHAR2(100),
  COMMON_AUTHOR_NAME   VARCHAR2(100),
  COMMON_CREATE_TIME   VARCHAR2(100),
  COMMON_MODIFYER_NAME VARCHAR2(100),
  COMMON_MODIFIER_ID   VARCHAR2(100),
  COMMON_MODIFY_TIME   VARCHAR2(100),
  COMMON_DISPLAY       INTEGER default 1,
  COMMON_EXTEND_1      VARCHAR2(1024),
  COMMON_EXTEND_2      VARCHAR2(1024),
  COMMON_DATA_SCOPE_ID INTEGER default 0,
  COMMON_RECORD_STATUS INTEGER default 1,
  COMMON_YEAR_ON       VARCHAR2(100),
  COMMON_MONTH_ON      VARCHAR2(100),
  constraint PK_WS_GROUP_USER primary key (ID)
);
-- Create sequence
create sequence SEQ_GROUP_USER
start with 1
increment by 1
nominvalue
nomaxvalue
nocache;

--创建同义词 请在金航集成平台的数据库中使用 以apps用户登录执行
--create or replace synonym WS_GROUP_USER for iqs.WS_GROUP_USER;
--create or replace synonym SEQ_GROUP_USER for iqs.SEQ_GROUP_USER;
