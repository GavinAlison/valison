/*�����ύ�����Ĳ���������ɫ�������ɿ��� Ĭ�϶��� ֵΪdept-role-group-relation ���Ը���������ɾ��*/
insert into ws_sys (PAR_NAME,PAR_VALUE,PAR_DESC) values('PRO_SELECT_USER_LEFT_TREE','dept-role-group-relation','�����ύ������������ʾ��dept role group relation �ֱ������ ��ɫ ϵͳ�û����� �û���ϵ,��-�ָ���');

/*���µ�ǰ��ű����*/
 update ws_sys set par_value='126', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
