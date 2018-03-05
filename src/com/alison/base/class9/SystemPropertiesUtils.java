package com.alison.base.class9;

import com.common.util.StaticMethod;

/**
 * 写一个类，获取properties文件中的键值对数据<br>
 * 有个默认的键值对数值，也有各个系统自己的键值对数据<br>
 * 原则在自己系统没有该值的情况下，使用默认的key-value值。<br>
 * 如果没有默认的，那么提示该值没有。
 * 
 * @author hy
 * 
 */
public class SystemPropertiesUtils {

	/**
	 * 默认的orgname, 该值存在于数据库的ws_sys表中， 不同的数据库，其中的orgname值是不同的
	 */
	public static String DEFAULT_ORGNAME = "default";

	/**
	 * 默认的key域分隔符
	 */
	public static String key_separator = ".";

	// 懒汉式单例模式
	private static SystemPropertiesUtils instance;

	public SystemPropertiesUtils() {
	}

	public static synchronized SystemPropertiesUtils getInstance() {
		if (instance == null) {
			instance = new SystemPropertiesUtils();
		}
		return instance;
	}

	/**
	 * 有确切的key和确切的orgname值
	 */
	public String getProperty(String key, String orgName) {
		return getProperty(key, orgName, true);
	}

	public String getProperty(String key, String orgName, boolean isHandle) {
		if (StaticMethod.isEmpty(key)) {
			// LogUtil.debug(SystemPropertyTag.class, " key is null.");
			return "";
		}
		// String value = getAppointProperty(key, orgName, isHandle);
		// LogUtil.debug(SystemPropertyTag.class, "appoint property value:["
		// + value + "]");
		// return value == null ?
		// StaticMethod.null2String(getDefaultProperty(key,
		// isHandle)) : value;
		return "";
	}
}
