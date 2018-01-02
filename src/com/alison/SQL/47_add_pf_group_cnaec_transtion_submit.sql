/*系统分组表增加列--默认提交数据值*/
alter table pf_group add submit_data varchar2(1024);
/*节点出口表中增加一列--提交数据过滤字段*/
alter table cnaec_transition add submit_dataitem_id varchar2(1024);
