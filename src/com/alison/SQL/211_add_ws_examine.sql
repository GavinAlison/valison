create table ws_examine_config(
       id varchar2(32),--主键
       key varchar2(4000),--标识
       sl_id varchar2(4000),--需要审核的密级门槛
       examine_user_name varchar2(4000),--审核人 当审核人是[leader]时 为部门领导
       constraint WS_PK_examine_config primary key (id)
);



create table WS_EXAMINE(
       id varchar2(32),--主键
       USER_NAME varchar2(4000),
       url varchar2(4000),
       TITLE varchar2(4000),
       SOURCE_USER_ID varchar2(4000),
       return_Spring_Bean varchar2(4000),
       submit_date date,
       status varchar2(32),
       APP_TASK_ID varchar2(4000),
       sl_id varchar2(4000),
       bsl_id varchar2(4000),
       constraint WS_PK_examine primary key (id)
);

create table WS_DEPT_SL_GROUP(
       id varchar2(32),--主键
       sl_id varchar2(4000),
       dept_id varchar2(4000),
       dept_sl_group_desc varchar2(4000),
       constraint WS_PK_DEPT_SL_GROUP primary key (id)
);

create table WS_SL_GROUP_USER(
       id varchar2(32),--主键
       sl_group_id varchar2(32),
       user_name varchar2(4000),
       constraint WS_PK_SL_GROUP_USER primary key (id)
);


create table WS_VIP_USER(
       id varchar2(32),--主键
       user_id varchar2(32),
       common_create_time varchar2(4000),
       constraint WS_PK_WS_VIP_USER primary key (id)
);


create table ws_examine_status(
	   id varchar2(32),--主键
       app_task_id varchar2(4000),
       examine_parameter varchar2(4000),
       constraint WS_PK_WS_examine_status primary key (id)
);

insert into ws_examine_config(id,key,sl_id,examine_user_name) values(sys_guid(),'PERSONAL_DOCUMENT_PROGRESSIVE','3','avicinfo.deptSlGroupProgressive');

update ws_sys set par_value='211', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
   
commit;