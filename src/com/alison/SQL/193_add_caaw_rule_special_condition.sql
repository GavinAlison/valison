alter table caaw_rule add special_condition varchar2(1024) default 0;

/*更新当前库脚本编号*/
 update ws_sys set par_value='193', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;