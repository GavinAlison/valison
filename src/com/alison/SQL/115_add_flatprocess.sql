/*
 扁平化流程相关sql 帖子中添加字段 存储流程实例id 
*/
alter table pf_topic add app_task_id varchar2(1024);

/*流程实例序列*/
create sequence SEQ_Pf_Flat_Process
minvalue 1
maxvalue 9999999999999999999999999999
start with 241
increment by 1
cache 20;

/*帖子附件 是否有密级 做成系统开关*/
insert into ws_sys (par_name,par_value,par_desc)values('PF_ATTACH_SL_SHOW','no','帖子附件是否显示密级');

/*添加扁平化流程自动发帖*/
CREATE TABLE ws_v2_pfflatprocessruleconfig
(
	version NUMBER not null,
    triggername varchar2(4000),
    acceptUser CLOB,
    moduleid VARCHAR2(1024),
    title VARCHAR2(4000),
    defaultUsers varchar(1024),
    knot_user varchar(1024),
	constraint PK_v2_pfprocsssrule primary key (triggername) 
);
/*集成贴使用 存储修改后变红数据项*/
alter table pf_topic_user add no_See_Report_Change varchar(4000);


/*更新当前库脚本编号*/
 update ws_sys set par_value='115', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
