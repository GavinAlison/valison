/*ws_user������ӱ�����չ�ֶ�common_extend_3��common_extend_7
 *commonExtend3;//��ʾ�½��û��Ƿ����ù��ܼ� 0δ����  1������
 *commonExtend4;//��ʾ�½��û��Ƿ����ù����� 0δ����  1������
*/
alter table ws_user add(common_extend_3 varchar2(1024),common_extend_4 varchar2(1024),common_extend_5 varchar2(1024),common_extend_6 varchar2(1024),common_extend_7 varchar2(1024));
update ws_sys set par_value='218', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') where par_name='DB_VERSION';
commit;
