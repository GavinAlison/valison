/*������������Ĭ�Ͽ�ת��������*/
insert into ws_sys (par_name,par_value,par_desc)values ('TABLETOPIC_FOWARD','yes','�����������˿�ת��������');
/*�������˴���״̬д���ֵ��*/
insert into ws_dictionary (DIC_ID,table_id,field_id,value_id,value_name) values (23,'pf_topic_user','t_type','0','������');
insert into ws_dictionary (DIC_ID,table_id,field_id,value_id,value_name) values (24,'pf_topic_user','t_type','1','�����');
/*���Ӹ������ܿ���*/
insert into ws_sys (par_name,par_value,par_desc)values ('ATTACHMENT_SL','yes','�����������˿�ת��������');
/*��������ƽ̨�����ܼ��ֶ�*/
alter table pf_accessories add  acc_sl_id varchar2(1024);