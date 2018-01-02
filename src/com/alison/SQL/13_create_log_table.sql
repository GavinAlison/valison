-- Create table
create table WS_LOG4J_LOG_DEBUG
(
  LOG4J_ID             NUMBER not null,
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
  LOG4J_METHOD         VARCHAR2(4000),
  LOG4J_IP             VARCHAR2(4000),
  LOG4J_DATE           VARCHAR2(4000),
  LOG4J_PRIORITY       VARCHAR2(4000),
  LOG4J_LOGNAME        VARCHAR2(4000),
  LOG4J_USERREALNAME   VARCHAR2(4000),
  LOG4J_MSG            VARCHAR2(4000)
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table WS_LOG4J_LOG_DEBUG
  add constraint PK_WS_LOG4J_LOG_DEBUG primary key (LOG4J_ID);
-- Create table
create table WS_LOG4J_LOG_INFO
(
  LOG4J_ID             NUMBER not null,
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
  LOG4J_METHOD         VARCHAR2(4000),
  LOG4J_IP             VARCHAR2(4000),
  LOG4J_DATE           VARCHAR2(4000),
  LOG4J_PRIORITY       VARCHAR2(4000),
  LOG4J_LOGNAME        VARCHAR2(4000),
  LOG4J_USERREALNAME   VARCHAR2(4000),
  LOG4J_MSG            VARCHAR2(4000)
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table WS_LOG4J_LOG_INFO
  add constraint PK_WS_LOG4J_LOG_INFO primary key (LOG4J_ID);

-- Create table
create table WS_LOG4J_LOG_ERROR
(
  LOG4J_ID             NUMBER not null,
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
  LOG4J_METHOD         VARCHAR2(4000),
  LOG4J_IP             VARCHAR2(4000),
  LOG4J_DATE           VARCHAR2(4000),
  LOG4J_PRIORITY       VARCHAR2(4000),
  LOG4J_LOGNAME        VARCHAR2(4000),
  LOG4J_USERREALNAME   VARCHAR2(4000),
  LOG4J_MSG            VARCHAR2(4000)
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table WS_LOG4J_LOG_ERROR
  add constraint PK_WS_LOG4J_LOG_ERROR primary key (LOG4J_ID);

-- Create table
create table WS_LOG4J_LOG_WARN
(
  LOG4J_ID             NUMBER not null,
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
  LOG4J_METHOD         VARCHAR2(4000),
  LOG4J_IP             VARCHAR2(4000),
  LOG4J_DATE           VARCHAR2(4000),
  LOG4J_PRIORITY       VARCHAR2(4000),
  LOG4J_LOGNAME        VARCHAR2(4000),
  LOG4J_USERREALNAME   VARCHAR2(4000),
  LOG4J_MSG            VARCHAR2(4000)
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table WS_LOG4J_LOG_WARN
  add constraint PK_WS_LOG4J_LOG_WARN primary key (LOG4J_ID);

-- Create table
create table WS_LOG4J_LOG_FATAL
(
  LOG4J_ID             NUMBER not null,
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
  LOG4J_METHOD         VARCHAR2(4000),
  LOG4J_IP             VARCHAR2(4000),
  LOG4J_DATE           VARCHAR2(4000),
  LOG4J_PRIORITY       VARCHAR2(4000),
  LOG4J_LOGNAME        VARCHAR2(4000),
  LOG4J_USERREALNAME   VARCHAR2(4000),
  LOG4J_MSG            VARCHAR2(4000)
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table WS_LOG4J_LOG_FATAL
  add constraint PK_WS_LOG4J_LOG_FATAL primary key (LOG4J_ID);
