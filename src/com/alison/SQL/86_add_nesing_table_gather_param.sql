/*增加嵌套表汇总参数*/
alter table cnaec_task_children_process add nesting_table_gather_param varchar2(1024);
/*在节点上增加是否做嵌套表汇总*/
alter table cnaec_transition add do_nesting_table_gather number default 0;
/*嵌套表如果使用的是已有的报表 需要执行以下sql：alter table ws_report_input_desc_嵌套表id add origin_child_process varchar2(1024);*/


/*更新当前库脚本编号*/
 update ws_sys set par_value='86', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
