/** 
У�����ݱ�Ͷ�Ӧ������ 
ʹ�÷�����
�� SQL ����ִ�� call PROC_CORRECT_TABLEANDSEQ('����','�����ֶ���','������');
*/

create or replace procedure PROC_SEQ_RESET(v_seqname varchar2)
as
n number(10);
-- =============================================
-- Description: �������У�nextvalΪ2
-- =============================================
begin

  execute immediate 'select '||v_seqname||'.nextval from dual' into n;
  if (n>1) then
    n := 1-n;
    execute immediate 'alter sequence '||v_seqname||' increment by '|| n;
    execute immediate 'select '||v_seqname||'.nextval from dual' into n;
    execute immediate 'alter sequence '||v_seqname||' increment by 1';
  end if;

end PROC_SEQ_RESET;

/
create or replace procedure PROC_CORRECT_TABLEANDSEQ(
  tableName in varchar2,
  seqFiled in varchar2,
  seqName in varchar2
)
as
v_table number;
v_seq number;
-- =======================================================
-- Description: У�����ݱ��������ֶ�ֵ��ʹ�õ����е�ǰֵ
-- =======================================================
begin
  execute immediate 'select max('||seqFiled||') from '||tableName||'' into v_table;
  execute immediate 'select '||seqName||'.nextval from dual' into v_seq;

  if (v_seq>v_table) then
    proc_seq_reset(seqName);
    v_seq := 2;
  end if;

  while(v_seq<v_table) loop
    execute immediate 'select '||seqName||'.nextval from dual' into v_seq;
  end loop;

end PROC_CORRECT_TABLEANDSEQ;
/

/*���µ�ǰ��ű����*/
update ws_sys set par_value='200', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
where par_name='DB_VERSION';
commit;

