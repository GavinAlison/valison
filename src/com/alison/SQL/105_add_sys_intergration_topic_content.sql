/*批示贴内容写到sys表中 可以根据需要修改*/
insert into ws_sys (PAR_NAME,PAR_VALUE,PAR_DESC) values('INTERGRATION_TOPIC_CONTENT','请领导批示','批示贴默认内容');

/*更新当前库脚本编号*/
 update ws_sys set par_value='105', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
