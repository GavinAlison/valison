/*ϵͳ�Զ��������ӽ�����*/
alter table ws_v2_pftopicruleconfig add knot_user varchar2(200);


/*���µ�ǰ��ű����*/
 update ws_sys set par_value='84', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';

