alter table CNAEC_PROCESSDEFINITION add UNI_CODE  varchar2(4000);
alter table CNAEC_PROCESSDEFINITION add constraint PRODEFINITION_UNI_CODE_UNIQUE unique(UNI_CODE);

alter table CNAEC_TASKDEFINITION add UNI_CODE  varchar2(4000);
alter table CNAEC_TASKDEFINITION add constraint TASKDEFINITION_UNI_CODE_UNIQUE unique(UNI_CODE);

alter table WS_REP_TABLE add UNI_CODE  varchar2(4000);
alter table WS_REP_TABLE add constraint REP_TABLE_UNI_CODE_UNIQUE unique(UNI_CODE);

alter table WS_DOMAIN add UNI_CODE  varchar2(4000);
alter table WS_DOMAIN add constraint DOMAIN_UNI_CODE_UNIQUE unique(UNI_CODE);

alter table WS_DATAITEM add UNI_CODE  varchar2(4000);
alter table WS_DATAITEM add constraint DATAITEM_UNI_CODE_UNIQUE unique(UNI_CODE);

alter table WS_ENUM add UNI_CODE  varchar2(4000);
alter table WS_ENUM add constraint ENUM_UNI_CODE_UNIQUE unique(UNI_CODE);

alter table WS_ENUM_VALUE add UNI_CODE  varchar2(4000);
alter table WS_ENUM_VALUE add constraint ENUM_VALUE_UNI_CODE_UNIQUE unique(UNI_CODE);


