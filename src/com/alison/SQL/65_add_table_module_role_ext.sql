/**建表 用来保存模块操作权限*/
-- Create table
create table ws_module_role_ext(
  ID                   NUMBER not null,
  DATA_SCOPE             NUMBER ,
  QUERYING      NUMBER ,
  CREATING        NUMBER ,
  MODIFYING  NUMBER ,
  CONTROLLING NUMBER ,
  PRINTING NUMBER ,
  EXPORTING NUMBER ,
  module_group_id  number  REFERENCES ws_module_user_group(id) ON DELETE CASCADE ,
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
  constraint PK_ws_module_role_ext primary key (ID)
);
-- Create sequence
create sequence SEQ_ws_module_role_ext
start with 1
increment by 1
nominvalue
nomaxvalue
nocache;

--����ͬ��� ���ڽ𺽼���ƽ̨����ݿ���ʹ�� ��apps�û���¼ִ��
--create or replace synonym WS_ws_module_role_ext for iqs.ws_module_role_ext;
--create or replace synonym SEQ_ws_module_role_ext for iqs.ws_module_role_ext;
/*ͬ�������*/
insert into ws_module_role_ext
  (id,
   Data_Scope,
   Querying,
   Creating,
   Modifying,
   Controlling,
   Printing,
   Exporting,
   Module_Group_Id)
  select SEQ_ws_module_role_ext.Nextval,
         u.data_scope,
         u.querying,
         u.creating,
         u.modifying,
         u.controlling,
         u.printing,
         u.exporting,
         u.id
    from  ws_module_user_group u
    
