/*
���ܣ��ַ�ת���������ͺ���
˵������to_date�����˷�װ��ʹ�÷�ʽͬto_date���ơ���������to_date����ʾ����, ���㴦��һЩ�����ַ�����
��������˵���� 
    str : ��Ҫת��Ϊ���ڵ��ַ���
    fmt : ���ڸ�ʽ(ͬto_date�е�Date Format)
    nls : �����ַ���������(ͬto_date�е�nlsparam)
����ֵ: 
   ����Ϊdate, ����ַ���������ת����ʽ��Ҫ����ǷǷ��������ַ���, ����ֵΪnull�� ��֮,����ת�����dateֵ
*/
CREATE OR REPLACE FUNCTION fn_to_date(str varchar2, fmt varchar2 default null, nls varchar2 default null)
RETURN date
IS
  v_date date;
  v_fmt varchar2(100) default fmt;
  v_nls varchar2(100) default nls;
BEGIN
  IF fmt IS NULL THEN
    SELECT value
      INTO v_fmt
      FROM v$nls_parameters
     WHERE parameter='NLS_DATE_FORMAT';
  END IF;
  IF nls IS NULL THEN
    SELECT 'NLS_DATE_LANGUAGE='''||value||''''
      INTO v_nls
      FROM v$nls_parameters
     WHERE parameter='NLS_DATE_LANGUAGE';
  END IF;
  v_date := to_date(str, v_fmt, v_nls);
  RETURN v_date;

  EXCEPTION
    WHEN OTHERS THEN
      /*�����ϣ����������, �Ͱ������ע���д�*/
      --raise;
      RETURN NULL;
END;
