/**数据项定义表增加一列自动编号参数**/
alter table ws_dataitem add auto_number varchar(200);
/**自动编号表增加一列周期为天**/
alter table ws_auto_number add day_on varchar(200);
