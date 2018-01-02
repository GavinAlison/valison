/*添加流程阅读状态字段 t_new,new,affirm*/
alter table ws_input_node_user add (T_NEW number default 0,new number default 0,affirm number default 0);

/*更新当前库脚本编号*/
 update ws_sys set par_value='119', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
