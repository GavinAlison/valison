--将common_record_status默认值改为1
--0为预警失效，1为预警生效
alter table  warning_config modify common_record_status default 1;
--将现有的置为生效
update warning_config t set t.common_record_status=1;
/*更新当前库脚本编号*/
update ws_sys set par_value='143', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;
