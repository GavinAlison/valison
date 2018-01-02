/*发起人指定节点接收人*/

/************流程表中加是否可指定接收人标识***************/
alter table CNAEC_PROCESSDEFINITION add LAUNCHER_ASSIGN INTEGER default 0;

drop table pd_instance_receiver;
/*==============================================================*/
/* Table: pd_instance_receiver   流程实例节点接收人             */
/*==============================================================*/
create table pd_instance_receiver  (
   id          	integer                         not null,
   process_instance_id               VARCHAR2(1024),
   td_id                        VARCHAR2(1024),
   user_id                      INTEGER,
   user_type          		INTEGER,
   status               	INTEGER,
   COMMON_ORDERBY       	VARCHAR2(100),
   COMMON_REMARK        	VARCHAR2(1024),
   COMMON_AUTHOR_ID     	VARCHAR2(100),
   COMMON_AUTHOR_NAME   	VARCHAR2(100),
   COMMON_CREATE_TIME   	VARCHAR2(100),
   COMMON_MODIFYER_NAME 	VARCHAR2(100),
   COMMON_MODIFIER_ID   	VARCHAR2(100),
   COMMON_MODIFY_TIME   	VARCHAR2(100),
   COMMON_DISPLAY       	INTEGER                        default 1,
   COMMON_EXTEND_1      	VARCHAR2(1024),
   COMMON_EXTEND_2      	VARCHAR2(1024),
   COMMON_DATA_SCOPE_ID 	INTEGER                        default 0,
   COMMON_RECORD_STATUS 	INTEGER                        default 1,
   COMMON_YEAR_ON       	VARCHAR2(100),
   COMMON_MONTH_ON      	VARCHAR2(100),

   constraint PK_instance_receiver primary key (id)
);

drop sequence SEQ_RECEIVER;
create sequence SEQ_RECEIVER
increment by 1
start with 1
 nominvalue
 nomaxvalue
;

drop table pd_instance_task;
/*==============================================================*/
/* Table: pd_instance_task   流程实例节点表             */
/*==============================================================*/
create table pd_instance_task  (
   id          	                integer                         not null,
   process_instance_id          VARCHAR2(1024),
   td_id                        VARCHAR2(1024),
   user_realname_str            VARCHAR2(4000),
   status               	INTEGER,
   COMMON_ORDERBY       	VARCHAR2(100),
   COMMON_REMARK        	VARCHAR2(1024),
   COMMON_AUTHOR_ID     	VARCHAR2(100),
   COMMON_AUTHOR_NAME   	VARCHAR2(100),
   COMMON_CREATE_TIME   	VARCHAR2(100),
   COMMON_MODIFYER_NAME 	VARCHAR2(100),
   COMMON_MODIFIER_ID   	VARCHAR2(100),
   COMMON_MODIFY_TIME   	VARCHAR2(100),
   COMMON_DISPLAY       	INTEGER                        default 1,
   COMMON_EXTEND_1      	VARCHAR2(1024),
   COMMON_EXTEND_2      	VARCHAR2(1024),
   COMMON_DATA_SCOPE_ID 	INTEGER                        default 0,
   COMMON_RECORD_STATUS 	INTEGER                        default 1,
   COMMON_YEAR_ON       	VARCHAR2(100),
   COMMON_MONTH_ON      	VARCHAR2(100),

   constraint PK_instance_task primary key (id)
);

drop sequence SEQ_INSTANCE_TASK;
create sequence SEQ_INSTANCE_TASK
increment by 1
start with 1
 nominvalue
 nomaxvalue
 ;
