/**���̳��ڷ�Ϊ����ͷ���0������1��������**/
alter table cnaec_transition  add direction number;
/**��������ݣ�Ĭ��Ϊ�������������Ҫ�ڽڵ�������ֶ��޸�**/
update cnaec_transition t set t.direction=1 ;