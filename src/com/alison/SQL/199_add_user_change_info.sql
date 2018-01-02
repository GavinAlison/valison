create table WS_USER_CHANGEINFO
(
  ID                VARCHAR2(32) not null,
  user_id              VARCHAR2(1024),
  info              VARCHAR2(4000),
  type varchar2(1024),
  common_create_time         VARCHAR2(1024),
  reason  varchar2(4000),
  constraint PK_WS_user_CHANGEINFO primary key (ID)
);
update ws_sys set par_value='199', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;