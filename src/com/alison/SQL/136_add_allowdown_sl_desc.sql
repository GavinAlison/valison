/**增加系统开关 附件允许下载的最低密级 默认为非密 即内部和秘密的附件不允许下载 只允许高密级用户查看**/
insert into ws_sys (par_name,par_value,par_desc)values('ATTACH_ALLOWDOWN_LOWEST_SL_DESC','3','附件允许下载的最低密级');

/*更新当前库脚本编号*/
 update ws_sys set par_value='136', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
