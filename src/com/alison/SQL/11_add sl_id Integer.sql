/**��WS_DOC_INFO������ֶ�SL_ID����¼�ĵ��ܼ�*/
alter table WS_DOC_INFO add sl_id Integer;


/**��ϵͳ�������ĵ����ܼ��ó�ϵͳ����ܼ�*/
update WS_DOC_INFO  set sl_id=(select max(to_number(sl_desc)) from ws_sl );


/**�������������ĵ�ws_manage_doc_info���洢���������ĵ���¼**************/

create table WS_MANAGE_DOC_INFO  (
   INFO_ID              NUMBER                          not null,
   CATE_ID              NUMBER                          not null,
   COMMON_ORDERBY       VARCHAR2(100),
   COMMON_REMARK        VARCHAR2(1024),
   COMMON_AUTHOR_ID     VARCHAR2(100),
   COMMON_AUTHOR_NAME   VARCHAR2(100),
   COMMON_CREATE_TIME   VARCHAR2(100),
   COMMON_MODIFYER_NAME VARCHAR2(100),
   COMMON_MODIFIER_ID   VARCHAR2(100),
   COMMON_MODIFY_TIME   VARCHAR2(100),
   COMMON_DISPLAY       INTEGER                        default 1,
   COMMON_EXTEND_1      VARCHAR2(1024),
   COMMON_EXTEND_2      VARCHAR2(1024),
   COMMON_DATA_SCOPE_ID INTEGER                        default 0,
   COMMON_RECORD_STATUS INTEGER                        default 1,
   COMMON_YEAR_ON       VARCHAR2(100),
   COMMON_MONTH_ON      VARCHAR2(100),
   INFO_NAME            VARCHAR2(1024),
   INFO_SN              VARCHAR2(1024),
   INFO_PUBDATE         TIMESTAMP,
   INFO_EXECDATE        TIMESTAMP,
   INFO_STATUS          NUMBER,
   INFO_KEYWORD         VARCHAR2(4000),
   INFO_ABSTRACT        CLOB,
   INFO_NOTE            VARCHAR2(4000),
   INFO_DEPT            VARCHAR2(4000),
   INFO_IMPORT          varchar2(4000),
   Info_Bag_number      varchar2(1024),                 /**ͼ����**/
   info_number          varchar2(1024),                 /**���**/��
   info_Cabinet_number  varchar2(1024),                 /**���**/
   info_Filing_realname varchar2(1024),                 /**�鵵������**/
   sl_id                INTEGER,
   
   constraint PK_WS_MANAGE_DOC_INFO primary key (INFO_ID)
);

comment on column WS_MANAGE_DOC_INFO.INFO_SN is
'��׼��';

comment on column WS_MANAGE_DOC_INFO.INFO_STATUS is
'�汾״̬ 1:��Ч 2:��ʷ 3:ɾ��';

comment on column WS_MANAGE_DOC_INFO.INFO_ABSTRACT is
'abstract';

/**

/**�½�ws_manage_doc_attachment��ws_manage_doc_cate��ws_manage_doc_c_quote��ws_manage_doc_quote������ϵ�ĵ�ϵ�б��ֶ�����ͬ*/

/*************�ĵ�����*******************/
create table WS_MANAGE_DOC_CATE  (
   CATE_ID              NUMBER                          not null,
   COMMON_ORDERBY       VARCHAR2(100),
   COMMON_REMARK        VARCHAR2(1024),
   COMMON_AUTHOR_ID     VARCHAR2(100),
   COMMON_AUTHOR_NAME   VARCHAR2(100),
   COMMON_CREATE_TIME   VARCHAR2(100),
   COMMON_MODIFYER_NAME VARCHAR2(100),
   COMMON_MODIFIER_ID   VARCHAR2(100),
   COMMON_MODIFY_TIME   VARCHAR2(100),
   COMMON_DISPLAY       INTEGER                        default 1,
   COMMON_EXTEND_1      VARCHAR2(1024),
   COMMON_EXTEND_2      VARCHAR2(1024),
   COMMON_DATA_SCOPE_ID INTEGER                        default 0,
   COMMON_RECORD_STATUS INTEGER                        default 1,
   COMMON_YEAR_ON       VARCHAR2(100),
   COMMON_MONTH_ON      VARCHAR2(100),
   CATE_NAME            VARCHAR2(1024),
   PARENT_CATE_ID       NUMBER,
   CATE_SN        VARCHAR2(1024),

   constraint PK_WS_MANAGE_DOC_CATE primary key (CATE_ID)
);
/******************�ĵ�������*************************/
create table WS_MANAGE_DOC_ATTACHMENT  (
   ATTACH_ID            NUMBER                          not null,
   INFO_ID              NUMBER                          ,
   COMMON_ORDERBY       VARCHAR2(100),
   COMMON_REMARK        VARCHAR2(1024),
   COMMON_AUTHOR_ID     VARCHAR2(100),
   COMMON_AUTHOR_NAME   VARCHAR2(100),
   COMMON_CREATE_TIME   VARCHAR2(100),
   COMMON_MODIFYER_NAME VARCHAR2(100),
   COMMON_MODIFIER_ID   VARCHAR2(100),
   COMMON_MODIFY_TIME   VARCHAR2(100),
   COMMON_DISPLAY       INTEGER                        default 1,
   COMMON_EXTEND_1      VARCHAR2(1024),
   COMMON_EXTEND_2      VARCHAR2(1024),
   COMMON_DATA_SCOPE_ID INTEGER                        default 0,
   COMMON_RECORD_STATUS INTEGER                        default 1,
   COMMON_YEAR_ON       VARCHAR2(100),
   COMMON_MONTH_ON      VARCHAR2(100),
   ATTACH_NAME          VARCHAR2(4000),
   ATTACH_REALNAME      VARCHAR2(4000),
   ATTACH_TYPE          NUMBER,
   ATTACH_STATUS    NUMBER,
   ATTACH_CONVERTNAME  VARCHAR2(1024),

   constraint PK_WS_MANAGE_DOC_ATTACHMENT primary key (ATTACH_ID)
);

comment on column WS_MANAGE_DOC_ATTACHMENT.ATTACH_TYPE is
'��������  1�������ĵ� 2�������ĵ�';

/************���ñ�************************/

create table WS_MANAGE_DOC_C_QUOTE  (
   INFO_ID              NUMBER                          not null,
   CATE_CHILD_ID       NUMBER                          not null,
   constraint PK_WS_MANAGE_DOC_C_QUOTE primary key (INFO_ID, CATE_CHILD_ID)
);
/*************���ñ�************/

create table WS_MAMAGE_DOC_QUOTE  (
   INFO_ID              NUMBER                          not null,
   INFO_CHILD_ID        NUMBER                          not null,
   constraint PK_WS_MANAGE_DOC_QUOTE primary key (INFO_ID, INFO_CHILD_ID)
);






