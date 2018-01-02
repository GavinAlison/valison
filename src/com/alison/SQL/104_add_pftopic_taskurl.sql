/*
直升机集成使用
批示贴中添加任务处理路径*/
alter table pf_topic add task_url varchar2(4000);
alter table pf_topic add app_task_id varchar2(1024);


/*更新当前库脚本编号*/
 update ws_sys set par_value='104', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
