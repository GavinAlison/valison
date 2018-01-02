/** 角色与节点的对应表*/
create table ws_group_work (
  group_ID VARCHAR2(1024),
  td_id VARCHAR2(1024),
  
  COMMON_ORDERBY       VARCHAR2(1024),
  COMMON_REMARK        VARCHAR2(1024),
  COMMON_AUTHOR_ID     VARCHAR2(1024),
  COMMON_AUTHOR_NAME   VARCHAR2(1024),
  COMMON_MODIFIER_ID     VARCHAR2(1024),
   COMMON_CREATE_TIME     VARCHAR2(1024),
  COMMON_MODIFYER_NAME VARCHAR2(1024),
  COMMON_MODIFY_TIME   VARCHAR2(1024),
  COMMON_DISPLAY       VARCHAR2(1024),
  COMMON_EXTEND_1      VARCHAR2(1024),
  COMMON_EXTEND_2      VARCHAR2(1024),
  COMMON_DATA_SCOPE_ID INTEGER,
  COMMON_RECORD_STATUS INTEGER,
  COMMON_YEAR_ON       VARCHAR2(1024),
  COMMON_MONTH_ON      VARCHAR2(1024)

);



/*处理旧数据 将原先指派好的人的所在角色全部添加到对应节点上 如需修改 请再调整用户角色等信息*/
insert into ws_group_work
  (td_id, group_id)
  select uw.td_id, gu.group_id
    from ws_user_work uw
   inner join ws_group_user gu
      on uw.user_id = gu.user_id
   group by group_id, td_id
  having td_id is not null and group_id is not null;


update ws_sys set par_value='95', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')  where par_name='DB_VERSION';
commit;
