/**��WS_MODULE���ֶ�MODULE_ICON����¼ģ��ͼ��*/
alter table WS_MODULE add module_icon varchar2(1024);




/**�Ӱ�ťʽ����ģ�����ã��粻���Ĭ����ԭ��������ģ��*/
insert into ws_sys (par_name,par_value,par_desc)values('INDEX_PAGE_URL','UserHomepageAction.do','�Ż�ʽ��¼ҳ��URL');
