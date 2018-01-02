package com.alison.base.javadoc;

/**
 javadoc 由源文件生成一个HTML文档
 抽取的信息有
 1. 包
 2. 公有的类与公有的接口
 3. 公有的和受保护的构造器和方法
 4. 公有的和受保护的域
 @author hy
 <em>强调文本</em>
 <code>代码</code>
 <strong>重强调</strong>
 <img>
 不要使用<h*><hr>，因为free-form text与html格式冲突
 */
/**
 * A <code>JavaDoc</code> Object represents javadoc。<br>
 * 类注解放在import之后，Class之前
 * 
 * @author hy
 */
public class JavaDocDemo {

	/**
	 * 
	 * @param dest
	 *            目标对象
	 * @param orgi
	 *            源对象
	 * @param flag
	 *            参数flag
	 * @return 返回
	 * @throws Exception
	 */
	public String exchangeValue(Object dest, Object orgi, int flag)
			throws Exception {
		
		return "";
	}

}
