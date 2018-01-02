/*统一待办表添加预警字段warning*/
alter table ws_union_task add warning varchar2(1024);
/*任务表添加模块id*/
alter table caaw_task add module_id varchar2(32);

/*更新当前库脚本编号*/
 update ws_sys set par_value='206', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';

commit;
