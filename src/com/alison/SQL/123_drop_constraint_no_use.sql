/*删掉无用约束条件*/
alter table WS_INPUT_DESC
   drop constraint FK_WS_INPUT_R_GENERAL_WS_REP_T ;
/*更新当前库脚本编号*/
 update ws_sys set par_value='123', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
