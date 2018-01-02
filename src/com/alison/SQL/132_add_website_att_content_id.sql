/*网站附件添加主表id字段*/
alter table ws_attachment  add content_id varchar2(1024);
/*更新当前库脚本编号*/
update ws_sys set par_value='132', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
