/*添加字段 用来存储预警模块跟踪列表的其他筛选条件*/
alter table warning_config add track_Where_Sql varchar2(1024) ;

/*更新当前库脚本编号*/
 update ws_sys set par_value='113', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
   commit;
   
