/**�л���ʱ�費��Ҫ���浱ǰ��(Ĭ��Ϊ��Ҫ)**/
insert into ws_sys (par_name,par_value,par_desc)values('REPORT_SAVE_CONFIRM','yes','��������ϸҳ���л���ʱ�費��Ҫ���浱ǰ��');
/*�޸�ֵ*/
update ws_sys t set t.par_value='no' where t.par_name='REPORT_SAVE_CONFIRM';