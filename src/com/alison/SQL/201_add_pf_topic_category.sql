alter table pf_topic add category varchar2(1024);

create table pf_Category(
	ID                VARCHAR2(32) not null,
  user_id              VARCHAR2(1024),
  category_name         VARCHAR2(1024),
  COMMON_CREATE_TIME  VARCHAR2(1024),
  constraint PK_pf_Category primary key (ID)
);


create table pf_TOPIC_Category(
	ID                VARCHAR2(32) not null,
  topic_id              VARCHAR2(1024),
  category_id         VARCHAR2(32),
  COMMON_CREATE_TIME  VARCHAR2(1024),
  constraint PK_pf_TOPIC_Category primary key (ID)
);
update ws_sys set par_value='201', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;