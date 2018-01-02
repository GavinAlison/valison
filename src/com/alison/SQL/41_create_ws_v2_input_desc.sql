------- 二维流程表单实例存储表
------- 注意修改表空间！！！！
-- Create table
create table WS_V2_INPUT_DESC
(
  INPUT_ID                INTEGER not null,
  ORG_CODE                VARCHAR2(1024),
  REP_TABLE_ID            INTEGER not null,
  COMMON_ORDERBY          VARCHAR2(100),
  COMMON_REMARK           VARCHAR2(1024),
  COMMON_AUTHOR_ID        VARCHAR2(100),
  COMMON_AUTHOR_NAME      VARCHAR2(100),
  COMMON_CREATE_TIME      VARCHAR2(100),
  COMMON_MODIFYER_NAME    VARCHAR2(100),
  COMMON_MODIFIER_ID      VARCHAR2(100),
  COMMON_MODIFY_TIME      VARCHAR2(100),
  COMMON_DISPLAY          INTEGER default 1,
  COMMON_EXTEND_1         VARCHAR2(1024),
  COMMON_EXTEND_2         VARCHAR2(1024),
  COMMON_DATA_SCOPE_ID    INTEGER default 0,
  COMMON_RECORD_STATUS    INTEGER default 1,
  COMMON_YEAR_ON          VARCHAR2(100),
  COMMON_MONTH_ON         VARCHAR2(100),
  INPUT_DATE              TIMESTAMP(6),
  INPUT_DATE_STR          VARCHAR2(1024),
  INPUT_USER              VARCHAR2(1024),
  INPUT_PROCESSINSTANCE   VARCHAR2(1024),
  INPUT_PROCESSDEFINITION VARCHAR2(1024),
  INPUT_FINISH_FLAG       VARCHAR2(1024),
  INPUT_CANCEL            VARCHAR2(1024),
  INPUT_WARN              VARCHAR2(1024),
  INPUT_PARANT            VARCHAR2(1024),
  INPUT_SAVE_FLAG         VARCHAR2(1024),
  INPUT_IMP_DATE          VARCHAR2(1024),
  CUR_TDID                VARCHAR2(100),
  FORMER_TDID             VARCHAR2(1024),
  INPUT_BLOCK             NUMBER
)
;
-- Create/Recreate primary, unique and foreign key constraints 
alter table WS_V2_INPUT_DESC
  add constraint PK_WS_V2_INPUT_DESC primary key (INPUT_ID)
  ;
alter table WS_V2_INPUT_DESC
  add constraint FK_WS_V2_INPUT_R_WS_ORG foreign key (ORG_CODE)
  references WS_ORG (ORG_CODE);
alter table WS_V2_INPUT_DESC
  add constraint FK_WS_V2_INPUT_R_WS_REP_T foreign key (REP_TABLE_ID)
  references WS_REP_TABLE (REP_TABLE_ID);
