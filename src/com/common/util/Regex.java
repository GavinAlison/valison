package com.common.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

public class Regex {
	// regex
	protected static String ipRegex = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$";
	protected static String intRegex = "\\d{1,11}";
	protected static String dataRegex = "\\d{4}-{1}\\d{1,2}-{1}\\d{1,2}";
	protected static String timeRegex = "\\d{1,2}:{1}\\d{1,2}:{1}\\d{1,2}";
	protected static String longDateRegex = "\\d{4}-{1}\\d{1,2}-{1}\\d{1,2} \\d{1,2}:{1}\\d{1,2}:{1}\\d{1,2}";
	protected static String longDateERegex = "\\d{4}-{1}\\d{1,2}-{1}\\d{1,2} \\d{1,2}:{1}\\d{1,2}:{1}\\d{1,2}\\.\\d{1,5}";
	protected static String emailRegex = "[A-Za-z0-9._%-]+@[A-Za-z0-9._%-]+\\.[A-Za-z]{2,10}";
	protected static String ftpRegex = "ftp://\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
	protected static String httpRegex = "http://\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}:\\d{1,5}.{0,200}";
	protected static String httpAllRegex = "((http://)?([a-z]+[.])|(www.))\\w+[.]([a-z]{2,4})?[[.]([a-z]{2,4})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z]{2,4}+|/?)";
	protected static String CN_1 = "[\u2E80-\u9FFF]+$";// 匹配所有东亚区的语言
	protected static String CN_2 = "[\u4E00-\u9FFF]+$ ";// 匹配简体和繁体
	protected static String CN_3 = "[\u4E00-\u9FA5]+$";// 简体

	// ip
	public static boolean isIp(String obj) {
		if (isEmpty(obj)) {
			return false;
		} else {
			return Pattern.matches(ipRegex, obj);
		}
	}

	// int
	public static boolean isInt(String obj) {
		if (isEmpty(obj)) {
			return false;
		} else {
			return Pattern.matches(intRegex, obj);
		}
	}

	public static boolean isInt(Integer obj) {
		if (isEmpty(obj)) {
			return false;
		} else {
			return Pattern.matches(intRegex, String.valueOf(obj));
		}
	}

	// date
	public static boolean isDate(Date date) {
		String obj = format(date);
		if (obj == null) {
			return false;
		} else {
			return Pattern.matches(dataRegex, obj);
		}
	}

	// time 大于当前时间
	public static boolean isAfter(Date date, String time) {
		String obj = format(date);
		if (obj == null) {
			return false;
		}
		StringBuffer b = new StringBuffer(obj);
		b.append(" ").append(time);
		Date in = parse(b.toString());
		if (in == null) {
			return false;
		}
		String now = fullFormat(new Date());
		if (now == null) {
			return false;
		}
		Date nowDate = parse(now);
		if (in.before(nowDate)) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isBefore(Date startDate, Date endDate) {
		return startDate.before(endDate);
	}

	// time
	public static boolean isTime(String obj) {
		if (isEmpty(obj)) {
			return false;
		} else {
			return Pattern.matches(timeRegex, obj);
		}
	}

	public static boolean isEmail(String obj) {
		if (isEmpty(obj)) {
			return false;
		} else {
			return Pattern.matches(emailRegex, obj);
		}
	}

	/**
	 * 短日期格式
	 * 
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		String f = null;
		if (isEmpty(date)) {
			return null;
		}
		try {
			Format format = new SimpleDateFormat("yyyy-MM-dd");
			f = format.format(date);
		} catch (Exception e) {
			return null;
		}
		return f;
	}

	/**
	 * 长日期格式
	 * 
	 * @param date
	 * @return
	 */
	public static String fullFormat(Date date) {
		String f = null;
		if (isEmpty(date)) {
			return null;
		}
		try {
			Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			f = format.format(date);
		} catch (Exception e) {
			return null;
		}
		return f;
	}

	/**
	 * 短日期中文格式
	 * 
	 * @param date
	 * @return
	 */
	public static String shortCHNFormat(Date date) {
		String f = null;
		if (isEmpty(date)) {
			return null;
		}
		try {
			Format format = new SimpleDateFormat("yyyy年MM月dd日");
			f = format.format(date);
		} catch (Exception e) {
			return null;
		}
		return f;
	}

	/**
	 * 长日期中文格式
	 * 
	 * @param date
	 * @return
	 */
	public static String fullCHNFormat(Date date) {
		String f = null;
		if (isEmpty(date)) {
			return null;
		}
		try {
			Format format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
			f = format.format(date);
		} catch (Exception e) {
			return null;
		}
		return f;
	}

	public static Date parse(String date) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d;
		try {
			d = format.parse(date);
		} catch (ParseException e) {
			return null;
		}
		return d;
	}

	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		} else if (obj instanceof String) {
			if ("".equals(((String) obj).trim())) {
				return true;
			}
		}
		return false;
	}

	// 获得ftp文件路径,"第一位:/,最后一位:无/"
	public static String getFtpDir(String s) {
		if (isEmpty(s)) {
			return "";
		}
		if (s.indexOf("/") != 0) {
			s = "/" + s;
		}
		if (s.lastIndexOf("/") + 1 == s.length()) {
			s = s.substring(0, s.length() - 1);
		}
		return s;
	}

	public static boolean isFtp(String s) {
		if (isEmpty(s)) {
			return false;
		}

		return Pattern.matches(ftpRegex, s);
	}

	public static boolean isHttp(String s) {
		if (isEmpty(s)) {
			return false;
		}
		return Pattern.matches(httpRegex, s);
	}

	public static boolean isAllHttp(String s) {
		if (isEmpty(s)) {
			return false;
		}
		return Pattern.matches(httpAllRegex, s);// org.apache.commons.validator.GenericValidator.isUrl(s);
	}

	public static boolean isCn(String s) {
		if (isEmpty(s)) {
			return false;
		} else {
			return Pattern.matches(CN_3, s);
		}
	}

	/**
	 * 获取随级字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) {
		StringBuffer buffer = new StringBuffer(
				"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int range = buffer.length();
		for (int i = 0; i < length; i++) {
			sb.append(buffer.charAt(r.nextInt(range)));
		}
		return sb.toString();
	}

	public static String upperFirstChar(String str) {
		if (isEmpty(str)) {
			return str;
		}
		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		for (int i = 1; i < ch.length; i++) {
			if (ch[i - 1] == 32 && (ch[i] >= 'a' && ch[i] <= 'z')) {
				ch[i] = (char) (ch[i] - 32);
			}
		}
		str = new String(ch);
		return str;
	}

	/**
	 * 四舍五入 保留 scale小数
	 * 
	 * @param d
	 * @param scale
	 * @return
	 */
	public static Double doubleFormat(Double d, int scale) {
		if (isEmpty(d)) {
			return 0.0;
		} else {
			BigDecimal b = new BigDecimal(d);
			return b.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
		}
	}

	/**
	 * 四舍五入 保留2位小数
	 * 
	 * @param d
	 * @return
	 */
	public static Double doubleFormat(Double d) {
		if (isEmpty(d)) {
			return 0.0;
		} else {
			return doubleFormat(d, 2);
		}
	}

	/**
	 * 计算时间差
	 * 
	 * @param date1
	 * @param date2
	 */
	public static String timeDifference(String date1, String date2) {
		if (!StaticMethod.isEmpty(date1) && !StaticMethod.isEmpty(date2)) {
			Date d1 = parse(date1);
			Date d2 = parse(date2);
			long diff = (d1.getTime() - d2.getTime()) / 1000;
			long day = diff / (24 * 3600);
			long hour = diff % (24 * 3600) / 3600;
			long min = diff % 3600 / 60;
			long se = diff % 60;
			if (day > 0) {
				return day + "天" + hour + "小时" + min + "分钟" + se + "秒";
			}
			if (hour > 0) {
				return hour + "小时" + min + "分钟" + se + "秒";
			}
			if (min > 0) {
				return min + "分钟" + se + "秒";
			}
			if (se > 0) {
				return se + "秒";
			}
		}
		return "";
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
		System.out.println(Regex.timeDifference("2013-11-12 11:21:00",
				"2013-11-12 11:11:11"));
	}
}
