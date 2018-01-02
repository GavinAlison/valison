/*excel嵌套表的宽度比值*/
alter table ws_dataitem add excel_input_width varchar2(1024);

/*更新当前库脚本编号*/
 update ws_sys set par_value='103', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';