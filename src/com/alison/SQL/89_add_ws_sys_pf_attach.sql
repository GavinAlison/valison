/**增加系统开关 帖子中上传的附件是否需要后缀(默认为否)以及是否需要加密(默认为是)**/
insert into ws_sys (par_name,par_value,par_desc)values('PF_ATTACH_SUFFIX','no','帖子中上传的附件在服务器磁盘上保存时是否有后缀');
insert into ws_sys (par_name,par_value,par_desc)values('PF_ATTACH_ENCRYPT','yes','帖子中上传的附件在服务器磁盘上是否需要加密');

/*更新当前库脚本编号*/
 update ws_sys set par_value='89', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
