--�ж��ַ����ֶε�ֵ�Ƿ������֣�����Ƿ��ظ���ֵ�����Ƿ���0
CREATE OR REPLACE FUNCTION isNumber(str IN VARCHAR2) RETURN NUMBER IS
  v_str FLOAT;
BEGIN
  IF str IS NULL THEN
    RETURN 0;
  ELSE
    BEGIN
      SELECT TO_NUMBER(str) INTO v_str FROM DUAL;
    EXCEPTION
      WHEN INVALID_NUMBER THEN
        RETURN 0;
    END;
    RETURN TO_NUMBER(str);
  END IF;
END isNumber;
