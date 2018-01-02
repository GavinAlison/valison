/*修改附件表文件名长度*/
alter table pf_accessories modify (acc_name varchar2(1024));
alter table pf_accessories modify (acc_true_name varchar2(1024));
