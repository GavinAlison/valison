package com.common.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.time.DateUtils;
import org.hibernate.SessionFactory;
import org.hibernate.util.StringHelper;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

public class StaticMethod extends Regex {

	/**
	 * yyyy-MM-dd
	 */
	public static String DATE_SHORT_PATTERN = "yyyy-MM-dd";
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static String DATE_LONG_PATTERN = "yyyy-MM-dd HH:mm:ss";
	/**
	 * yyyy-MM-dd HH:mm:ss.SS
	 */
	public static String DATE_LONGE_PATTERN = "yyyy-MM-dd HH:mm:ss.SS";
	/**
	 * EEE MMM dd HH:mm:ss zzz yyyy
	 */
	public static String DATE_CST_PATTERN = "EEE MMM dd HH:mm:ss zzz yyyy";
	// private static Logger logger = Logger.getLogger(StaticMethod.class);

	public static final String PLACEHOLDER_PREFIX = "${";

	public static final String PLACEHOLDER_SUFFIX = "}";

	public static String[] DATE_PATTERN = new String[] {
			"yyyy-MM-dd HH:mm:ss.SSS", "yyyy-MM-dd HH:mm", "yyyy-MM-dd",
			"yyyy-MM-dd HH:mm:ss.SS", "EEE MMM dd HH:mm:ss zzz yyyy",
			"yyyy-MM", "yyyyMM", "yyyy/MM", "yyyyMMdd", "yyyy-MM-dd",
			"yyyy/MM/dd", "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss",
			"yyyy/MM/dd HH:mm:ss", "yyyy" };

	public static String method2class(Method method) {
		String methodName = method.getName();
		String clz = method.getDeclaringClass().getName();
		Class<?> paramTypes[] = method.getParameterTypes();
		String types = "";
		if (paramTypes != null && paramTypes.length > 0) {
			for (int i = 0; i < paramTypes.length; i++)
				types = types + paramTypes[i].getName() + ",";

			types = types.substring(0, types.length() - 1);

		}
		return clz + "." + methodName + "(" + types + ")";
	}

	/**
	 * 修饰一下才能满足Extjs的Json格式
	 * 
	 * @param str
	 * @return
	 */
	public static String modifyExtjsJsonModify(String str) {
		if (StaticMethod.isEmpty(str)) {
			str = "";
		}
		return ("[" + str + "]").replaceAll(",]", "]");
	}

	/**
	 * 如果字符串为null或者不能转换成整型，返回为0
	 * 
	 * @param s
	 * @return
	 */
	public static int nullString2int(String s) {
		int i = 0;
		try {
			i = Integer.parseInt(s);
		} catch (Exception e) {
			i = 0;
		}
		return i;
	}

	/**
	 * 如果字符串为null，返回为空，否则返回该字符串
	 * 
	 * @param s
	 * @return
	 */
	public static String nullString2String(String s) {
		String str = "";
		try {
			if (s != null) {
				str = s;
			}
		} catch (Exception e) {
			str = "";
		}
		return str;
	}

	/**
	 * 如果对象为null，返回为空串，否则返回该对象的字符串
	 * 
	 * @param s
	 * @return
	 */
	public static String nullObject2String(Object s) {
		return StaticMethod.nullObject2String(s, "");
	}

	/**
	 * 如果对象为null，返回为给定的默认值，否则返回该对象的字符串
	 * 
	 * @param s
	 * @return
	 */
	public static String nullObject2String(Object s, String d) {
		String str = "";
		try {
			str = s.toString();
		} catch (Exception e) {
			str = d;
		}
		return str;
	}

	/**
	 * 如果对象可以转换为整型，则返回，否则返回给定的默认值
	 * 
	 * @param s
	 * @param in
	 * @return
	 */
	public static int nullObject2int(Object s, int in) {
		String str = "";
		int i = in;
		try {
			str = s.toString();
			i = Integer.parseInt(str);
		} catch (Exception e) {
			i = in;
		}
		return i;
	}

	public static int nullObject2int(Object s) {
		return StaticMethod.nullObject2int(s, 0);
	}

	/**
	 * 如果对象可以转换为长整型，则返回，否则返回给定的默认值
	 * 
	 * @param s
	 * @param dl
	 * @return
	 */
	public static Long nullObject2Long(Object s, Long dl) {
		try {
			return Long.parseLong(s.toString());
		} catch (Exception e) {
			return dl;
		}
	}

	public static Long nullObject2Long(Object s) {
		return StaticMethod.nullObject2Long(s, 0L);
	}

	/**
	 * 如果对象可以转换为数字，则返回，否则返回给定的默认值
	 * 
	 * @param s
	 * @param dd
	 * @return
	 */
	public static Double nullObject2Double(Object s, Double dd) {
		try {
			return Double.parseDouble(s.toString());
		} catch (Exception e) {
			return dd;
		}
	}

	public static Double nullObject2Double(Object s) {
		return StaticMethod.nullObject2Double(s, 0d);
	}

	/**
	 * 如果对象可以转换为数字，则返回，否则返回给定的默认值
	 * 
	 * @param s
	 * @param dd
	 * @return
	 */
	public static BigDecimal nullObject2BigDecimal(Object s, BigDecimal dd) {
		try {
			return new BigDecimal(s.toString());
		} catch (Exception e) {
			return dd;
		}
	}

	public static BigDecimal nullObject2BigDecimal(Object s) {
		return StaticMethod.nullObject2BigDecimal(s, BigDecimal.valueOf(0L));
	}

	/**
	 * 根据输入的格式(String _dtFormat)得到当前时间格式
	 * 
	 * @param _dtFormat
	 * @return
	 */
	public static String getCurrentDateTime(String _dtFormat) {
		String currentdatetime = "";
		try {
			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat dtFormat = new SimpleDateFormat(_dtFormat);
			currentdatetime = dtFormat.format(date);
		} catch (Exception e) {
			System.out.println("时间格式不正确");
			e.printStackTrace();
		}
		return currentdatetime;
	}

	/**
	 * 根据输入的格式(String _dtFormat)得到上个月的时间格式
	 * 
	 * @param _dtFormat
	 * @return
	 */
	public static String getPreMonthDateTime() {
		String currentdatetime = "";
		try {
			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat dtFormat = new SimpleDateFormat(DATE_LONG_PATTERN);
			currentdatetime = dtFormat.format(date);
			String year = currentdatetime.substring(0, 4);
			String month = currentdatetime.substring(5, 7);
			Long yearL = Long.valueOf(year);
			Long monthL = Long.valueOf(month);
			if (monthL.equals(1L)) {
				monthL = 12L;
				yearL--;
			} else {
				monthL--;
			}
			year = yearL.toString();
			if (monthL < 10L) {
				month = "0" + monthL;
			} else {
				month = monthL.toString();
			}
			String time = currentdatetime.substring(8);
			currentdatetime = year + "-" + month + "-" + time;
		} catch (Exception e) {
			System.out.println("时间格式不正确");
			e.printStackTrace();
		}
		return currentdatetime;
	}

	/**
	 * 根据输入的格式(String _dtFormat)得到下一个月的时间格式
	 * 
	 * @param _dtFormat
	 * @return
	 */
	public static String getNextMonthDateTime() {
		String currentdatetime = "";
		try {
			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat dtFormat = new SimpleDateFormat(DATE_LONG_PATTERN);
			currentdatetime = dtFormat.format(date);
			String year = currentdatetime.substring(0, 4);
			String month = currentdatetime.substring(5, 7);
			Long yearL = Long.valueOf(year);
			Long monthL = Long.valueOf(month);
			if (monthL.equals(12L)) {
				monthL = 1L;
				yearL++;
			} else {
				monthL++;
			}
			year = yearL.toString();
			if (monthL < 10L) {
				month = "0" + monthL;
			}
			String time = currentdatetime.substring(7);
			currentdatetime = year + "-" + month + "-" + time;
		} catch (Exception e) {
			System.out.println("时间格式不正确");
			e.printStackTrace();
		}
		return currentdatetime;
	}

	/**
	 * 得到所给日期相隔 天数的 日期
	 * 
	 * @param date
	 *            日期
	 * @param day
	 *            相差天数 例如：-1 前一天
	 * @param _dtFormat
	 *            返回日期的格式
	 * 
	 */
	public static String getDefferDay_DateTime(Date date, int day,
			String _dtFormat) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
		date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat(_dtFormat);
		return formatter.format(date);

	}

	/**
	 * 计算当前季度
	 * 
	 * @param month
	 * @return
	 */
	public static String getCurrentQuarter() {
		Integer quarter = Calendar.getInstance().get(Calendar.MONTH) / 3 + 1;
		return quarter.toString();
	}

	public static void populate(Object bean, String prefix, String suffix,
			HttpServletRequest request) throws ServletException {
		// Build a list of relevant request parameters from this request
		HashMap properties = new HashMap();
		// Iterator of parameter names
		Enumeration names = null;
		names = request.getParameterNames();

		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String stripped = name;
			if (prefix != null) {
				if (!stripped.startsWith(prefix)) {
					continue;
				}
				stripped = stripped.substring(prefix.length());
			}
			if (suffix != null) {
				if (!stripped.endsWith(suffix)) {
					continue;
				}
				stripped = stripped.substring(0, stripped.length()
						- suffix.length());
			}
			Object parameterValue = null;
			parameterValue = request.getParameterValues(name);
			if (!(stripped.startsWith("org.apache.struts."))) {
				properties.put(stripped, parameterValue);
			}
		}
		// Set the corresponding properties of our bean
		try {
			BeanUtils.populate(bean, properties);
		} catch (Exception e) {
			throw new ServletException("BeanUtils.populate", e);
		} finally {
		}
	}

	public static void populate(Object bean, HttpServletRequest request)
			throws ServletException {
		populate(bean, null, null, request);
	}

	// 将Unicode字符串转换成bool型数组
	public boolean[] StrToBool(String input) {
		boolean[] output = Binstr16ToBool(BinstrToBinstr16(StrToBinstr(input)));
		return output;
	}

	// 将bool型数组转换成Unicode字符串
	public String BoolToStr(boolean[] input) {
		String output = BinstrToStr(Binstr16ToBinstr(BoolToBinstr16(input)));
		return output;
	}

	// 将字符串转换成二进制字符串，以空格相隔
	private String StrToBinstr(String str) {
		char[] strChar = str.toCharArray();
		String result = "";
		for (int i = 0; i < strChar.length; i++) {
			result += Integer.toBinaryString(strChar[i]) + " ";
		}
		return result;
	}

	// 将二进制字符串转换成Unicode字符串
	private String BinstrToStr(String binStr) {
		String[] tempStr = StrToStrArray(binStr);
		char[] tempChar = new char[tempStr.length];
		for (int i = 0; i < tempStr.length; i++) {
			tempChar[i] = BinstrToChar(tempStr[i]);
		}
		return String.valueOf(tempChar);
	}

	// 将二进制字符串格式化成全16位带空格的Binstr
	private String BinstrToBinstr16(String input) {
		StringBuffer output = new StringBuffer();
		String[] tempStr = StrToStrArray(input);
		for (int i = 0; i < tempStr.length; i++) {
			for (int j = 16 - tempStr[i].length(); j > 0; j--)
				output.append('0');
			output.append(tempStr[i] + " ");
		}
		return output.toString();
	}

	// 将全16位带空格的Binstr转化成去0前缀的带空格Binstr
	private String Binstr16ToBinstr(String input) {
		StringBuffer output = new StringBuffer();
		String[] tempStr = StrToStrArray(input);
		for (int i = 0; i < tempStr.length; i++) {
			for (int j = 0; j < 16; j++) {
				if (tempStr[i].charAt(j) == '1') {
					output.append(tempStr[i].substring(j) + " ");
					break;
				}
				if (j == 15 && tempStr[i].charAt(j) == '0')
					output.append("0" + " ");
			}
		}
		return output.toString();
	}

	// 二进制字串转化为boolean型数组 输入16位有空格的Binstr
	private boolean[] Binstr16ToBool(String input) {
		String[] tempStr = StrToStrArray(input);
		boolean[] output = new boolean[tempStr.length * 16];
		for (int i = 0, j = 0; i < input.length(); i++, j++)
			if (input.charAt(i) == '1')
				output[j] = true;
			else if (input.charAt(i) == '0')
				output[j] = false;
			else
				j--;
		return output;
	}

	// boolean型数组转化为二进制字串 返回带0前缀16位有空格的Binstr
	private String BoolToBinstr16(boolean[] input) {
		StringBuffer output = new StringBuffer();
		for (int i = 0; i < input.length; i++) {
			if (input[i])
				output.append('1');
			else
				output.append('0');
			if ((i + 1) % 16 == 0)
				output.append(' ');
		}
		output.append(' ');
		return output.toString();
	}

	// 将二进制字符串转换为char
	private char BinstrToChar(String binStr) {
		int[] temp = BinstrToIntArray(binStr);
		int sum = 0;
		for (int i = 0; i < temp.length; i++) {
			sum += temp[temp.length - 1 - i] << i;
		}
		return (char) sum;
	}

	// 将初始二进制字符串转换成字符串数组，以空格相隔
	private String[] StrToStrArray(String str) {
		return str.split(" ");
	}

	// 将二进制字符串转换成int数组
	private int[] BinstrToIntArray(String binStr) {
		char[] temp = binStr.toCharArray();
		int[] result = new int[temp.length];
		for (int i = 0; i < temp.length; i++) {
			result[i] = temp[i] - 48;
		}
		return result;
	}

	public static Date addYears(Date date, int amount) {
		return add(date, Calendar.YEAR, amount);
	}

	public static Date addMonths(Date date, int amount) {
		return add(date, Calendar.MONTH, amount);
	}

	public static Date addWeeks(Date date, int amount) {
		return add(date, Calendar.WEEK_OF_YEAR, amount);
	}

	public static Date addDays(Date date, int amount) {
		return add(date, Calendar.DATE, amount);
	}

	public static Date addHours(Date date, int amount) {
		return add(date, Calendar.HOUR_OF_DAY, amount);
	}

	public static Date addMinutes(Date date, int amount) {
		return add(date, Calendar.MINUTE, amount);
	}

	public static Date addSeconds(Date date, int amount) {
		return add(date, Calendar.SECOND, amount);
	}

	public static Date addMilliseconds(Date date, int amount) {
		return add(date, Calendar.MILLISECOND, amount);
	}

	private static Date add(Date date, int calendarField, int amount) {
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null");
		} else {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(calendarField, amount);
			return c.getTime();
		}
	}

	/* 大字段显示替换 */
	public static String contentShow(String content) {
		String result = "";
		if (content != null) {
			result = content.replaceAll("\\n", "<br>");
			result = result.replaceAll("  ", "&nbsp; ");

		}
		return result;
	}

	/**
	 * 支持 <br>
	 * <b>yyyy-MM-dd</b><br>
	 * <b>yyyy-MM-dd HH:mm:ss</b><br>
	 * <b>yyyy-MM-dd HH:mm:ss.SS</b><br>
	 * <b>EEE MMM dd HH:mm:ss zzz yyyy</b><br>
	 * 
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date parseToDate(String str) throws ParseException {
		return DateUtils.parseDate(str, DATE_PATTERN);
	}

	/**
	 * 模版元素替换
	 * 
	 * @param template
	 * @param elements
	 * @return
	 */
	public static String replace(String template, Object[] elements) {
		for (int i = 0; i < elements.length; i++) {
			template = StringHelper.replace(template, "${" + i + "}", String
					.valueOf(elements[i]));
		}
		return template;
	}

	/**
	 * 根据ResultSet替换 ${id} 替换成rs中对应的列值
	 * 
	 * @param strVal
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public static String parseStringValue(String strVal, final ResultSet rs)
			throws SQLException {
		if (strVal == null) {
			return null;
		}
		StringBuilder buf = new StringBuilder(strVal);
		int startIndex = strVal.indexOf(PLACEHOLDER_PREFIX);
		while (startIndex != -1) {
			int endIndex = buf.indexOf(PLACEHOLDER_SUFFIX, startIndex
					+ PLACEHOLDER_PREFIX.length());
			if (endIndex != -1) {
				String column = buf.substring(startIndex
						+ PLACEHOLDER_PREFIX.length(), endIndex);
				int columnIndex = rs.findColumn(column);
				String value = null;
				if (columnIndex > 0) {
					value = rs.getString(columnIndex);
				}
				if (value != null) {
					buf = buf.replace(startIndex, endIndex
							+ PLACEHOLDER_SUFFIX.length(), value);
					startIndex = endIndex - value.length()
							- PLACEHOLDER_PREFIX.length();
				} else {
					buf = buf.replace(startIndex, endIndex
							+ PLACEHOLDER_SUFFIX.length(), "");
					startIndex = endIndex + PLACEHOLDER_SUFFIX.length();
				}
				startIndex = buf.indexOf(PLACEHOLDER_PREFIX, startIndex);
			} else {
				startIndex = -1;
			}
		}
		return buf.toString();
	}

	/**
	 * map转化成bean
	 * 
	 * @param <T>
	 * @param type
	 * @param map
	 * @return
	 */
	public static <T> T mapConvertBean(Class<T> type, Map<String, Object> map) {
		T t = null;
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(type);
			// 获取类属性
			t = type.newInstance();
			for (PropertyDescriptor descriptor : beanInfo
					.getPropertyDescriptors()) {
				String propertyName = descriptor.getName();
				System.out.println("------------pn:" + propertyName);
				if (map.containsKey(propertyName)) {
					System.out
							.println("------------pv"
									+ map.get(propertyName)
									+ "  "
									+ map.get(propertyName).getClass()
									+ "  "
									+ descriptor.getWriteMethod()
											.getParameterTypes()[0]);
					Object obj = formatValue(String.valueOf(map
							.get(propertyName)), descriptor.getWriteMethod()
							.getParameterTypes()[0]);
					descriptor.getWriteMethod().invoke(t, obj);
					System.out.println("!");
				}
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return t;
	}

	/**
	 * bean转为map
	 * 
	 * @param o
	 * @return
	 */
	public static Map<String, Object> beanConvertMap(Object o) {
		try {
			Map<String, Object> beanMap = BeanUtils.describe(o);
			return beanMap;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * 将map中数据与bean中属性类型一致
	 * 
	 * <功能详细描述>
	 * 
	 * @param fieldValue
	 *            属性值
	 * 
	 * @param fieldType
	 *            属性类型
	 * 
	 * @return formatValue 格式化数据
	 * 
	 */
	private static Object formatValue(String fieldValue,
			Class<? extends Object> fieldType) {
		Object value = null;
		if (fieldType == Integer.class || int.class.equals(fieldType)) {
			if (!isEmpty(fieldValue)) {
				value = Integer.parseInt(fieldValue);
			} else {
				value = 0;
			}
		} else if (fieldType == Long.class || long.class.equals(fieldType)) {
			if (!isEmpty(fieldValue)) {
				value = Long.parseLong(fieldValue);
			} else {
				value = 0l;
			}
		} else if (fieldType == Float.class || float.class.equals(fieldType)) {
			if (!isEmpty(fieldValue)) {
				value = Float.parseFloat(fieldValue);
			} else {
				value = 0f;
			}
		} else if (fieldType == Double.class || double.class.equals(fieldType)) {
			if (!isEmpty(fieldValue)) {
				value = Double.parseDouble(fieldValue);
			} else {
				value = 0.0;
			}
		} else if (fieldType == Date.class || fieldType == java.util.Date.class) {
			if (!isEmpty(fieldValue)) {
				try {
					value = parseToDate(fieldValue);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		} else {
			value = fieldValue;
		}
		return value;
	}

	public static void main(String[] args) {
		System.out.println(Regex.isEmail("huamin.wang@itibia.com"));
		System.out.println(Regex.isInt("0.3"));
		System.out.println(Regex.isEmail("huamin_2009@163.com"));
		System.out.println(Regex.isFtp("ftp://192.168.0.201"));
		System.out.println(Regex.isAllHttp("aaa"));
		System.out.println(Regex.isCn("繁體简体"));
		String asd = "^[d|D](\\d+)$";
		System.out.println(Pattern.matches(asd, "ssad"));
		System.out.println(Pattern.matches(asd, "s1"));
		System.out.println(Pattern.matches(asd, "d1"));
		System.out.println(Pattern.matches(asd, "d"));
		System.out.println(Pattern.matches(asd, "d123123"));
		System.out.println(Pattern.matches(asd, "D123123"));
		System.out.println(Pattern.matches(longDateERegex,
				"2012-01-11 00:00:00.1"));

		SimpleDateFormat f = new SimpleDateFormat(DATE_LONGE_PATTERN);
		try {
			f.parse("2012-01-11 00:00:00.1");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String s = "http://www.baidu.com";
		String s1 = null;
		try {
			s1 = getHtml(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println((new StringBuilder()).append("ss:").append(s1)
				.toString());
	}

	/**
	 * 获取两个日期之间的月份数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException
	 * @author lisen
	 */
	public static int getMonthCount(Date dateFrom, Date dateTo)
			throws ParseException {
		// 保证dataFrom
		if (dateFrom.compareTo(dateTo) > 0) {
			Date temp = null;
			temp = dateFrom;
			dateFrom = dateTo;
			dateTo = temp;
			temp = null;
		}
		Calendar cl = Calendar.getInstance();
		cl.setTime(dateFrom);
		int fromYear = cl.get(Calendar.YEAR);
		int fromMonth = cl.get(Calendar.MONTH) + 1;

		cl.setTime(dateTo);
		int toYear = cl.get(Calendar.YEAR);
		int toMonth = cl.get(Calendar.MONTH) + 1;

		int result = 0;
		if (fromYear == toYear) {
			for (int i = fromMonth; i <= toMonth; i++) {
				result++;
			}
		} else {
			for (int i = fromYear; i <= toYear; i++) {
				if (i == fromYear) {
					for (int j = fromMonth; j <= 12; j++) {
						result++;
					}
				} else if (i == toYear) {
					for (int j = 1; j <= toMonth; j++) {
						result++;
					}
				} else {
					for (int j = 1; j <= 12; j++) {
						result++;
					}
				}
			}
		}
		return result;
	}

	public static boolean validateRegex(String regex, String value) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(value);
		return m.find();

	}

	/**
	 * 返回字符串中符合正则表达式的子串
	 * 
	 * @param regex
	 *            正则表达式
	 * @param value
	 *            源字符串
	 * @return List<String>
	 */
	public static List<String> macherRegex(String regex, String value) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(value);
		List<String> list = new ArrayList<String>();
		while (m.find()) {
			list.add(m.group());
		}
		return list;

	}

	// 判断字符串是否是整数
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	public static final String getHtml(String urlStr) throws IOException {
		InputStream is = null;
		StringWriter sw;
		HttpURLConnection conn = null;
		try {
			char ac[];
			URL url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			is = conn.getInputStream();
			sw = new StringWriter();
			if (is != null) {
				BufferedReader bufferedreader = new BufferedReader(
						new InputStreamReader(is, "UTF-8"));
				int i;
				ac = new char[1024];
				while ((i = bufferedreader.read(ac)) != -1) {
					sw.write(ac, 0, i);
				}
			}
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
			if (is != null) {
				is.close();
			}
		}

		return sw.toString();
	}

	/**
	 * 判断对象o实现的所有接口中是否有szInterface <br>
	 * 
	 * public interface ITest extends Serializable<br>
	 * public class Test1 implements ITest<br>
	 * public class Test2 extends Test1<br>
	 * public class Test3 extends Test2 <br>
	 * 
	 * isInterface(Test3.class, "java.io.Serializable") = true<br>
	 * isInterface(Test3.class, "test.ITest") = true<br>
	 * 
	 * @param c
	 * @param szInterface
	 * @return
	 */
	public static boolean hasInterface(Class c, String szInterface) {
		Class[] faces = c.getInterfaces();
		for (Class face : faces) {
			if (face.getName().equals(szInterface)) {
				return true;
			} else {
				Class[] faces1 = face.getInterfaces();
				for (Class face1 : faces1) {
					if (face1.getName().equals(szInterface)) {
						return true;
					} else if (hasInterface(face1, szInterface)) {
						return true;
					}
				}
			}
		}
		if (null != c.getSuperclass()) {
			return hasInterface(c.getSuperclass(), szInterface);
		}
		return false;
	}

	/**
	 * 处理html 去掉换行和空格 转义引号
	 * 
	 * @param s
	 * @return
	 */
	public static String trimHTML(String s) {
		if (s != null && s.length() > 0) {
			// s = s.replaceAll("(\r|\n|\r\n|\n\r)", " ");
			s = s.replaceAll("(\r\n|\n\r|\r|\n)", "<br>");
			s = s.replaceAll("\"", "\\\\" + "\"");
			s = s.replaceAll("\'", "\\\\" + "\'");
			return s;
		} else {
			return "";
		}
	}

	/**
	 * 去掉html标签
	 * 
	 * @param inputString
	 * @return
	 */
	public static String HtmlToText(String inputString) {
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;

		java.util.regex.Pattern p_html1;
		java.util.regex.Matcher m_html1;

		try {
			String regEx_script = "<[//s]*?script[^>]*?>[//s//S]*?<[//s]*?///[//s]*?script[//s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[//s//S]*?<///script>
			String regEx_style = "<[//s]*?style[^>]*?>[//s//S]*?<[//s]*?///[//s]*?style[//s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[//s//S]*?<///style>
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
			String regEx_html1 = "<[^>]+";
			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签

			p_html1 = Pattern.compile(regEx_html1, Pattern.CASE_INSENSITIVE);
			m_html1 = p_html1.matcher(htmlStr);
			htmlStr = m_html1.replaceAll(""); // 过滤html标签

			textStr = htmlStr;

		} catch (Exception e) {
			System.err.println("Html2Text: " + e.getMessage());
		}

		return textStr;// 返回文本字符串
	}

	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		} else if (obj instanceof String) {
			if (((String) obj).equals("")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 将指定的date转换成String格式
	 * 
	 * @param date
	 * @param _dateFormat
	 * @return
	 */
	public static String parseToDateString(Date date, String _dateFormat) {
		SimpleDateFormat dt = new SimpleDateFormat(_dateFormat);
		return dt.format(date);
	}
}
