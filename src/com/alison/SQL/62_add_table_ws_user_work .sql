/*将ws_user_work转换为表 用来存储用户和节点的关系 注意修改表空间！！执行前确保第38条已经执行过！！！*/
-- Create table
create table WS_USER_WORK_TEMP
(
  TD_ID                INTEGER not null,
  USER_ID              INTEGER not null,
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
  COMMON_MONTH_ON      VARCHAR2(100)
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table WS_USER_WORK_TEMP
  add constraint PK_WS_USER_WORK primary key (TD_ID, USER_ID)
 ;
alter table WS_USER_WORK_TEMP
  add constraint FK_WS_USER__RELATIONS_CNAEC_TA foreign key (TD_ID)
  references CNAEC_TASKDEFINITION (TD_ID);
alter table WS_USER_WORK_TEMP
  add constraint FK_WS_USE__RELATIONS_WS_USER foreign key (USER_ID)
  references WS_USER (USER_ID);

/*处理旧数据*/
insert into ws_user_work_temp(user_id,td_id) select wuw.user_id,wuw.td_id from ws_user_work wuw where wuw.user_id in(
select u.user_id from ws_user u 
) and td_id in(
select td.td_id from cnaec_taskdefinition td
);
commit;
drop view ws_user_work;
rename ws_user_work_temp to ws_user_work;

