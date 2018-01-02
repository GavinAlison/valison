/*报表贴接收人默认可转发工作贴*/
insert into ws_sys (par_name,par_value,par_desc)values ('TABLETOPIC_FOWARD','yes','报表贴接收人可转发工作贴');
/*将接收人处理状态写入字典表*/
insert into ws_dictionary (DIC_ID,table_id,field_id,value_id,value_name) values (23,'pf_topic_user','t_type','0','待处理');
insert into ws_dictionary (DIC_ID,table_id,field_id,value_id,value_name) values (24,'pf_topic_user','t_type','1','已完成');
/*增加附件标密开关*/
insert into ws_sys (par_name,par_value,par_desc)values ('ATTACHMENT_SL','yes','报表贴接收人可转发工作贴');
/*新增交互平台附件密级字段*/
alter table pf_accessories add  acc_sl_id varchar2(1024);