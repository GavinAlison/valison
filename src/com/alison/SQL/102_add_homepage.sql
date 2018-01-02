/*首页可定制*/
insert into ws_sys (par_name,par_value,par_desc)values('homepage','homepage.js','各个系统定制的首页js');
/*更新当前库脚本编号*/
 update ws_sys set par_value='102', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
