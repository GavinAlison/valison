select * from ws_enum_value t where t.enum_id=102/** ��ϵͳ�� */
/** drop and create table */
drop table caaw_aircraft_subsystem cascade constraints;
create table caaw_aircraft_subsystem (
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
  
  --����Ի��ֶΣ�
  MODEL_REC_ID VARCHAR2(1024),
  AIRCRAFT_SUBSYSTEM_ID VARCHAR2(1024),
  AIRCRAFT_SUBSYSTEM_NAME_CH VARCHAR2(1024),
  AIRCRAFT_SUBSYSTEM_NAME_EN VARCHAR2(1024),
  AIRCRAFT_SUBSYSTEM_NO VARCHAR2(1024),
  constraint PK_CAAW_AIRCRAFT_SUBSYSTEM primary key (ID)
);

/** create sequence */
drop sequence SEQ_CAAW_AIRCRAFT_SUBSYSTEM;
create sequence SEQ_CAAW_AIRCRAFT_SUBSYSTEM
start with 1
increment by 1
nominvalue
nomaxvalue
nocache;

/** create view */
/**
CREATE or REPLACE view V_CAAW_AIRCRAFT_SUBSYSTEM as
SELECT * FROM caaw_aircraft_subsystem 
*/

--create synonym for avicit user : apps
--create or replace synonym CAAW_AIRCRAFT_SUBSYSTEM for caaw.CAAW_AIRCRAFT_SUBSYSTEM;
