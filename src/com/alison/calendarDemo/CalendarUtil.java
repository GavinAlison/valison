package com.alison.calendarDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

public class CalendarUtil {
	// 获取当前月的天数
	public int getDayOfMonth() {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		return cal.getActualMaximum(Calendar.DATE);
	}

	// 获取当前月每天的日期
	public List getDayListOfMonth() {
		List list = new ArrayList();
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		for (int i = 0; i <= day; i++) {
			list.add(year + "/" + month + "/" + i);
		}
		return list;
	}

	public static void main(String[] args) {
		CalendarUtil util = new CalendarUtil();
		List<String> list = util.getDayListOfMonth();
		// for (String str : list) {
		// System.out.println(str);
		// }
	}

	@Test
	public void test01() {
		String str = "";
		try {
			// 字符串转换日期格式
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new Date()
					.toLocaleString());
			// 完整显示今天日期时间
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").format(new Date());
			// 创建 Calendar 对象
			Calendar cal = Calendar.getInstance();
			try {
				// 对 cal 设置时间的方法
				// 设置传入的时间格式
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-M-d H:m:s");
				Date date = dateFormat.parse("2017-10-9 16:39:11");
				// 指定一个日期
				cal.setTime(date);
				// 按特定格式显示刚设置的时间
				str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")
						.format(cal.getTime()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 或者另一種設置 cal 方式
			// 分別爲 year, month, date, hourOfDay, minute, second
			cal = Calendar.getInstance();
			cal.set(2013, 1, 2, 17, 35, 44);
			str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(cal
					.getTime());
			// Calendar 取得当前时间的方法
			// 初始化 (重置) Calendar 对象
			cal = Calendar.getInstance();
			// 或者用 Date 来初始化 Calendar 对象
			cal.setTime(new Date());
			// setTime 类似上面一行
			// Date date = new Date();
			// cal.setTime(date);
			str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(cal
					.getTime());
			System.out.println(str);
			// 显示年份
			int year = cal.get(Calendar.YEAR);
			System.out.println("year is = " + String.valueOf(year));

			// 显示月份 (从0开始, 实际显示要加一)
			int month = cal.get(Calendar.MONTH);
			System.out.println("nth is = " + (month + 1));

			// 本周几
			int week = cal.get(Calendar.DAY_OF_WEEK);
			System.out.println("week is = " + week);

			// 今年的第 N 天
			int DAY_OF_YEAR = cal.get(Calendar.DAY_OF_YEAR);
			System.out.println("DAY_OF_YEAR is = " + DAY_OF_YEAR);

			// 本月第 N 天
			int DAY_OF_MONTH = cal.get(Calendar.DAY_OF_MONTH);
			System.out
					.println("DAY_OF_MONTH = " + String.valueOf(DAY_OF_MONTH));

			// 3小时以后
			cal.add(Calendar.HOUR_OF_DAY, 3);
			int HOUR_OF_DAY = cal.get(Calendar.HOUR_OF_DAY);
			System.out.println("HOUR_OF_DAY + 3 = " + HOUR_OF_DAY);

			// 当前分钟数
			int MINUTE = cal.get(Calendar.MINUTE);
			System.out.println("MINUTE = " + MINUTE);

			// 15 分钟以后
			cal.add(Calendar.MINUTE, 15);
			MINUTE = cal.get(Calendar.MINUTE);
			System.out.println("MINUTE + 15 = " + MINUTE);

			// 30分钟前
			cal.add(Calendar.MINUTE, -30);
			MINUTE = cal.get(Calendar.MINUTE);
			System.out.println("MINUTE - 30 = " + MINUTE);

			// 格式化显示
			str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(cal
					.getTime());
			System.out.println(str);

			// 重置 Calendar 显示当前时间
			cal.setTime(new Date());
			str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(cal
					.getTime());
			System.out.println(str);

			// 创建一个 Calendar 用于比较时间
			Calendar calendarNew = Calendar.getInstance();

			// 设定为 5 小时以前，后者大，显示 -1
			calendarNew.add(Calendar.HOUR, -5);
			System.out.println("时间比较：" + calendarNew.compareTo(cal));

			// 设定7小时以后，前者大，显示 1
			calendarNew.add(Calendar.HOUR, +7);
			System.out.println("时间比较：" + calendarNew.compareTo(cal));

			// 退回 2 小时，时间相同，显示 0
			calendarNew.add(Calendar.HOUR, -2);
			System.out.println("时间比较：" + calendarNew.compareTo(cal));

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test02() {
		Calendar cal = Calendar.getInstance();
		// max of day_on_month
		cal.get(Calendar.DAY_OF_MONTH);
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(maxDay);
		cal.set(Calendar.MONDAY, 1);
		int temp = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(temp);
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2017, 1, 1);
		int last = cal2.getActualMaximum(Calendar.DATE);
		System.out.println("该月的最后一天last...." + last);
		System.out.println("---------------------");
	}
}
