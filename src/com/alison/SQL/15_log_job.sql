--删除日志记录触发器
create or replace procedure delete_Info_Log
as
begin
--删除六个月以前的日志记录
    delete from ws_log4j_log  t  where  MONTHS_BETWEEN(sysdate,to_date(t.log4j_date,'YYYY-MM-DD HH24:MI:SS'))>=6;
    commit;
end  delete_Info_Log;



--创建一个每天凌晨一点执行删除日志存储过程的定时器
declare delete_log_job number;
  begin

    dbms_job.submit(delete_log_job, 'delete_Info_Log;', sysdate, 'TRUNC(sysdate) + 1 +1/ (24)');
--参数列表（JOB别名，到期执行的存储过程名称，开始生效时间，执行频率:每天凌晨一点）
 end
commit;
