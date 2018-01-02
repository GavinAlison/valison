/** 个性化模块关注 */
/** drop and create table */
drop table ws_Concern_User_Instance cascade constraints;
create table ws_Concern_User_Instance (
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
  
  --表个性化字段：MAIN_ 开始
  user_Name VARCHAR2(1024),
  INPUT_PROCESSINSTANCE VARCHAR2(1024),
  MODULE_ID VARCHAR2(1024),
  CONCERN_TITLE VARCHAR2(1024),
  SUBMIT_USER VARCHAR2(1024),
  SUBMIT_TIME VARCHAR2(1024),
  T_NEW NUMBER,
  constraint PK_WSCONCERNUSERINSTANCE primary key (ID)
);

/** create sequence */
drop sequence SEQ_WSCONCERNUSERINSTANCE;
create sequence SEQ_WSCONCERNUSERINSTANCE
start with 1
increment by 1
nominvalue
nomaxvalue
nocache;

/** create view */
/**
CREATE or REPLACE view V_WSCONCERNUSERINSTANCE as
SELECT * FROM wsConcernUserInstance 
*/

--create synonym for avicit user : apps
--create or replace synonym WSCONCERNUSERINSTANCE for .WSCONCERNUSERINSTANCE;
/*更新当前库脚本编号*/
 update ws_sys set par_value='128', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';

