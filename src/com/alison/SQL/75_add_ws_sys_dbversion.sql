
--���ܣ���¼���ݿ�������Ϣ
--�������������������������������������������������������������������������� 
--˵����
--1��ִ�������SQL�ű�����ws_sys���д���һ�����ݿ�������¼
   insert into ws_sys(par_name, par_value, par_desc, common_modify_time)
   values('DB_VERSION', '75', '���ݿ�汾��¼', to_char(sysdate,'yyyy-MM-dd HH24:mi:ss'));
--2���Ժ��ڽ������ݿ��޸�ʱ����ÿ��SQL�ű��ļ������������䣬��¼����ִ�еĽű����
 --  update ws_sys set par_value=[�滻Ϊ���νű����], common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
 --  where par_name='DB_VERSION';
--�������������������������������������������������������������������������� 
