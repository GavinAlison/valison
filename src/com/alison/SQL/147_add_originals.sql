--�ʺ�����ϵͳ
--��������ԭ�ĸ����ֶ�
alter table caaw_rule  add ORIGINALS  VARCHAR2(4000);
--���������
update  caaw_rule  t set t.sheet_accessories=replace(t.sheet_accessories,',','') where t.sheet_accessories like'%,%';
update ws_sys set par_value='147', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;
