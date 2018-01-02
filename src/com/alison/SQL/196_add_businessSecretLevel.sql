create table WS_BSL
(
  ID                VARCHAR2(32) not null,
  SL_NAME              VARCHAR2(1024),
  SL_DESC              VARCHAR2(1024),
  USER_SL_NAME         VARCHAR2(1024),
  constraint PK_WS_bSL primary key (ID)
);


insert into WS_BSL (ID, SL_NAME, SL_DESC, USER_SL_NAME)
values ('40288ab2588ab07f01588ab49ef80002', '普通商密', '2', '普通商密人员');

insert into WS_BSL (ID, SL_NAME, SL_DESC, USER_SL_NAME)
values ('40288ab2588abdbb01588ac009090001', '公开', '3', '其他人员');

insert into WS_BSL (ID, SL_NAME, SL_DESC, USER_SL_NAME)
values ('40288ab2588ab07f01588ab32dab0001', '核心商密', '1', '核心商密人员');

--添加商密字段
alter table ws_user add bsl_id varchar2(32);
alter table pf_topic add bsl_id varchar2(32);
alter table pf_topic add examine_Flag varchar2(32);
alter table pf_reply add examine_Flag varchar2(32);
alter table pf_reply add bsl_id varchar2(32);
update ws_user set bsl_id='40288ab2588abdbb01588ac009090001';

update ws_sys set par_value='196', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;

commit;
