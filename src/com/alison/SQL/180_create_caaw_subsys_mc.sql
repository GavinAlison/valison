/*﻿子系统MC表*/
create table caaw_subsys_mc
(
  /*pk*/
  ID                    VARCHAR2(32) primary key,
    VERSION                 NUMBER not null,
  COMMON_ORDERBY         VARCHAR2(1024),
  COMMON_REMARK          VARCHAR2(1024),
  COMMON_AUTHOR_ID       VARCHAR2(1024),
  COMMON_AUTHOR_NAME     VARCHAR2(1024),
  COMMON_MODIFYER_NAME   VARCHAR2(1024),
  COMMON_MODIFY_TIME     VARCHAR2(1024),
  COMMON_CREATE_TIME       VARCHAR2(100),
  COMMON_DISPLAY         VARCHAR2(1024),
  COMMON_EXTEND_1        VARCHAR2(1024),
  COMMON_EXTEND_2       VARCHAR2(1024),
  COMMON_DATA_SCOPE_ID   NUMBER default 0,
  COMMON_RECORD_STATUS   NUMBER default 0,
  COMMON_YEAR_ON         VARCHAR2(1024),
  COMMON_MONTH_ON        VARCHAR2(1024),
  DATA_GROUP_ID          VARCHAR2(1024),
  COMMON_DELETED         NUMBER default 0,
  
  SHEET_ACCEPT_LIMIT     DATE,
  SHEET_COMPLETE_LIMIT   DATE,
  
  SHEET_ACCESSORIES      VARCHAR2(4000),  
  ATTACHMENT_ID      NUMBER default 0,
    
  cp_id varchar2(1024),
  clause_id varchar2(1024),
  ata_id varchar2(1024),
  ata varchar2(1024),
  mc_id varchar2(1024),
  MC varchar2(100)
);
create sequence SEQ_caaw_subsys_mc
start with 1
increment by 1
nominvalue
nomaxvalue
nocache;

/*更新当前库脚本编号*/
 update ws_sys set par_value='180', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;
