package com.alison;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import com.lisen.Hex.HexTest;

public class LogUtil {

	/*
	 * 
	 * 记录导致系统无法使用的事件
	 * 
	 * 推荐：非程序异常导致的系统不可用，
	 * 
	 * 比如：在运行中，数据库连接中断，导致无法进行数据库操作， 属非用户操作不当，且不可预见的异常，这种事件应使用该级别
	 * 
	 */
	public static void fatal(Class clazz, String info) {
		// Log log = LogFactory.getLog(clazz);
		Logger log = Logger.getLogger(clazz);
		log.fatal(HexTest.toHexString(info));
	}

	/*
	 * 模块出错了。比如系统中一个文件没了，导致功能模块所有功能都不可用。还包括引发多个模块功能异常的事件。
	 * 
	 * 推荐：基本上用不到，比如：按照说明，在OTNMS中，系统管理整个不可用使用该级别才是正确的，而只有系统管理整个模块不可用几乎不可能
	 */
	public static void error(Class clazz, Exception ex) {
		// Log log = LogFactory.getLog(clazz);
		Logger log = Logger.getLogger(clazz);
		StringBuffer buffer = new StringBuffer();
		buffer.append("Exception:  " + ex + "\n");
		buffer.append("Message: " + ex.getMessage() + "\n");
		StackTraceElement[] stack = ex.getStackTrace();
		for (int i = 0; i < stack.length; i++) {
			buffer.append("\n        " + stack[i].toString());
		}
		log.error(HexTest.toHexString(buffer.toString()));
	}

	public static void error(Class clazz, String errMessage) {
		// Log log = LogFactory.getLog(clazz);
		Logger log = Logger.getLogger(clazz);
		log.error(HexTest.toHexString(errMessage));
	}

	/*
	 * 
	 * 模块异常了。比如系统中一个文件没了，但是只影响部分非关键功能，模块其他主要功能还是能用的。
	 * 
	 * 推荐：在抛出异常时使用该级别记录,或者用户输入非法数据导致系统不能走正常流程的事件
	 * 
	 */
	public static void warn(Class clazz, Exception ex) {
		// Log log = LogFactory.getLog(clazz);
		Logger log = Logger.getLogger(clazz);
		StringBuffer buffer = new StringBuffer();
		buffer.append("Exception:  " + ex + "\n");
		buffer.append("Message: " + ex.getMessage() + "\n");
		StackTraceElement[] stack = ex.getStackTrace();
		for (int i = 0; i < stack.length; i++) {
			buffer.append("\n        -" + stack[i].toString());
		}
		log.error(HexTest.toHexString(buffer.toString()));
	}

	/*
	 * 关键的业务事件
	 * 
	 * 推荐：登陆，注销等，上传文件成功，失败等 用该级别记录
	 */
	public static void info(Class clazz, String info) {
		info(clazz, info, "");
	}

	public static void info(Class clazz, String info, String reason) {
		Log log = LogFactory.getLog(clazz);
		info = HexTest.toHexString(info);
		MDC.put("reason", reason);
		log.info(info);
	}

	/*
	 * 
	 * 调试日志
	 * 
	 * 推荐：这种级别的输出信息只为在开发过程中方便程序调试（linux下），开发完成后一律屏蔽掉
	 * 
	 */
	public static void debug(Class clazz, String info) {
		// Log log = LogFactory.getLog(clazz);
		Logger log = Logger.getLogger(clazz);
		info = HexTest.toHexString(info);
		log.debug(info);
	}
}
