--ɾ����־��¼������
create or replace procedure delete_Info_Log
as
begin
--ɾ����������ǰ����־��¼
    delete from ws_log4j_log  t  where  MONTHS_BETWEEN(sysdate,to_date(t.log4j_date,'YYYY-MM-DD HH24:MI:SS'))>=6;
    commit;
end  delete_Info_Log;



--����һ��ÿ���賿һ��ִ��ɾ����־�洢���̵Ķ�ʱ��
declare delete_log_job number;
  begin

    dbms_job.submit(delete_log_job, 'delete_Info_Log;', sysdate, 'TRUNC(sysdate) + 1 +1/ (24)');
--�����б�JOB����������ִ�еĴ洢�������ƣ���ʼ��Чʱ�䣬ִ��Ƶ��:ÿ���賿һ�㣩
 end
commit;
