/*
功能：字符转换日期类型函数
说明：对to_date进行了封装，使用方式同to_date类似。可以屏蔽to_date的显示报错, 方便处理一些日期字符串。
函数参数说明： 
    str : 需要转换为日期的字符串
    fmt : 日期格式(同to_date中的Date Format)
    nls : 日期字符串的语言(同to_date中的nlsparam)
返回值: 
   类型为date, 如果字符串不符合转换格式的要求或是非法的日期字符串, 返回值为null。 反之,返回转换后的date值
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
      /*如果你希望看到报错, 就把下面的注释行打开*/
      --raise;
      RETURN NULL;
END;
