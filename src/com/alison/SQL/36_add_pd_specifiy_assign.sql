/*流程表中加是否可指定接收人标识(所有人 不只是发起人) 默认值为0。0：不能指定；1:可以指定。*/
alter table CNAEC_PROCESSDEFINITION add SPECIFIY_ASSIGN INTEGER default 0;
