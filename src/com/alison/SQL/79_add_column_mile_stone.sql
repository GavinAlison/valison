/*添加里程碑标识字段,是为1,否为0,默认为否*/
alter table caaw_project_templet add mile_stone VARCHAR2(32) default 0;
alter table caaw_task add mile_stone VARCHAR2(32) default 0;

/*更新当前库脚本编号*/
 update ws_sys set par_value='79', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';