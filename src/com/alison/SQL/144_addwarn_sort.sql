--添加预警分类字段
alter table  warning_config add WARN_SORT varchar2(1024);
/*更新当前库脚本编号*/
update ws_sys set par_value='144', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;
