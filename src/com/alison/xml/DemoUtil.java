package com.alison.xml;

import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class DemoUtil {
	private static String xmlFile = "http://com/alison/xml/test.xml";

	private String xmlfileD1 = "src//com//alison//xml//sida.xml";

	public static void main(String[] args) throws Exception {
		// java.net.URL;
		// Foo.getInstance().parse(new File(xmlFile));
		URL url = new URL(xmlFile);
		// System.out.println(url);
		DemoUtil d = new DemoUtil();
		// d.test01();
		d.test02();
	}

	@Test
	public void test01() {
		// 创建SAXReader对象
		SAXReader reader = new SAXReader();
		try {
			// 读取xml文件
			Document document = reader.read(new File(xmlfileD1));
			// 获取根结点
			Element root = document.getRootElement();
			// root.getText()获取的根结点为三个换行符\r\n\r\n\r\n
			// root.getTextTrim()//去除换车与换行字符，取出all Text,CDATA and Entitynodes
			// System.out.print("root's text: " + root.getTextTrim());
			// System.out.println("root node type: " + root.getNodeType());
			// 获取某个节点的子节点
			Element el = root.element("红楼梦");
			// System.out.print("element text: " + el.getTextTrim());
			// 获取某节点下所有名为作者的子节点(不包括孙子节点), 并进行遍历，
			// 根结点下没有<作者>节点，就找不到
			System.out.println("=================");
			List nodes = root.elements("作者");
			for (Iterator it = nodes.iterator(); it.hasNext();) {
				Element elementz = (Element) it.next();
				System.out.println(elementz.getName() + " - "
						+ elementz.getTextTrim());
			}
			System.out.println("=================");
			// System.out.println();
			// 对某节点下的所有子节点进行遍历
			// for (Iterator it = root.elementIterator(); it.hasNext();) {
			// Element elementn = (Element) it.next();
			// System.out.print(elementn.getName() + " - "
			// + elementn.getText());
			// }
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

	public void test02() {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "	<ReqMsg>"
				+ "		<header>" + "			<sendSysName>APP_PORTAL</sendSysName>"
				+ "			<rcvSysName>APP_PMS</rcvSysName>" + "			<extConfig>"
				+ "				<isReTry>false</isReTry>" + "			</extConfig>"
				+ "		</header>" + "	<document>" + "		<![CDATA["
				+ "			<USERINFO>" + "				<userId>用户编码</userId>"
				+ "<deptCode>组织机构编码</deptCode>" + "<userName>用户名</userName>"
				+ "<userPassword>密码</userPassword>" + "<status>状态标识</status>"
				+ "</USERINFO>" + "]]>" + "</document></ReqMsg>";

		try {
			Document doc = DocumentHelper.parseText(xml);
			Element root = doc.getRootElement();
			
			Element docEl = root.element("document");
			String dataStr = docEl.getTextTrim();
			doc = DocumentHelper.parseText(dataStr);
			root = doc.getRootElement();
			
			Element userId = root.element("userId");
			System.out.println(userId.getTextTrim());
			

		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

}
