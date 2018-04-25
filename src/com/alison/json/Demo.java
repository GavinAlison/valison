package com.alison.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.junit.Test;

public class Demo {

	// 1.List集合转换成json代码 JSONArray
	@Test
	public void Method01() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("asd");
		JSONArray arr = JSONArray.fromObject(list);
		System.out.println(arr);
	}

	// 2.map集合转换层json代码 JSONObject
	@SuppressWarnings("unchecked")
	@Test
	public void method02() {
		Map map = new HashMap();
		map.put("name", "json");
		map.put("bool", Boolean.TRUE);
		map.put("int", Integer.MAX_VALUE);
		JSONObject obj = JSONObject.fromObject(map);
		System.out.println(obj);
	}

	// 3. Bean 转换成json代码 JSONObject
	@Test
	public void method03() {
		Student stu = new Student("json", 24);
		JSONObject obj = JSONObject.fromObject(stu);
		System.out.println(obj.toString());
	}

	// 4.数组转换成json代码 JSONArray
	@Test
	public void method04() {
		String[] arr = new String[] { "1", "a", "json" };
		JSONArray jsonArr = JSONArray.fromObject(arr);
		System.out.println(jsonArr);
	}

	// 5.一般数据转换成json代码 JSONArray
	@Test
	public void method05() {
		JSONArray arr = JSONArray.fromObject("['json', 'is', 'easy']");
		System.out.println(arr);
	}

	@Test
	public void method06() {
		String str = "[{'name':'json', 'age':'19', 'sex':'男', 'height':'200cm'},"
				+ "{'name':'json1', 'age':'10', 'sex':'男', 'height':'210cm'}]";
		JSONArray arr = JSONArray.fromObject(str);
		System.out.println(arr);
	}

	/**
	 * 6. 属性过滤 <br>
	 * 
	 * <pre>
	 * 1.实现jsonConfig接口 <br>
	 * 2.设置jsonconfig.setJsonproperties()<br>
	 * 3.设置jsonconfig.setExcludes
	 * </pre>
	 */
	@Test
	public void method00() {
		Student stu = new Student("json", 24);
		JsonConfig config = new JsonConfig();
		// config.setjsonpropertyfilter(new propertyfilter() {
		//			
		// @override
		// public boolean apply(object source, string name, object value) {
		// if("pagebeanlist".equalsignorecase(name)
		// || "name".equalsignorecase(name)){
		// return true;
		// }
		// return false;
		// }
		// });
		// 或者config.setExcludes 注意区分大小写
		config.setExcludes(new String[] { "pageBeanList", "name" });
		JSONObject obj = JSONObject.fromObject(stu, config);
		System.out.println(obj);
	}

	// 出现JSONUtil.bean2Json()报has no read method. SKIPPED问题
	// 解决方法
	@SuppressWarnings("unchecked")
	@Test
	public void method07() {
		List list = new ArrayList();
		list.add(1);
		list.add("a");
		Student stu = new Student("hh", 21, list);
		JSONObject obj = JSONObject.fromObject(stu);
		System.out.println(obj);
		/*
		 * 出现Property 'pageBeanList' of class com.alison.json.Student has no
		 * read method. SKIPPED 解决方法 1.在bean类中添加 getPageBeanList方法 <br>
		 * 2.排除这个属性pageBeanList
		 */

	}

	/**
	 * <pre>
	 * String pmsItemArr = this.pms_itemService
	 * 		.jsonAllPms_item(new Pms_itemListObject());
	 * jsonconfig config = new jsonconfig();
	 * config.setjsonpropertyfilter(new propertyfilter() {
	 * 	\@override
	 * 	public boolean apply(object obj, string property, object obj1) {
	 * 		if (&quot;day&quot;.equals(property) 
	 * 				|| &quot;timezoneoffset&quot;.equals(property)) {
	 * 			return true;
	 * 		}
	 * 		return false;
	 * 	}
	 * });
	 * jsonarray jsonarrpmsitem = jsonarray.fromobject(pmsitemarr, config);
	 * list&lt;pms_itemlistobject&gt; pms_itemlist = (list&lt;pms_itemlistobject&gt;) jsonarray
	 * 		.tocollection(jsonarrpmsitem, pms_itemListObject.class);
	 * 
	 * </pre>
	 */
	/**
	 * 使用JSON包中的JSONObject.fromObject()方法和JSONArray的add方法,加入JSONObject对象，
	 * 然后利用JSONArray的toString()输出json格式的字符串
	 */
	public String method08() {
		MessageBox m1 = new MessageBox(1, "1", "1", "1");
		MessageBox m2 = new MessageBox(2, "2", "2", "2");
		MessageBox m3 = new MessageBox(3, "3", "3", "3");
		MessageBox m4 = new MessageBox(4, "4", "4", "4");
		MessageBox m5 = new MessageBox(5, "5", "5", "5");
		List<MessageBox> list = new ArrayList<MessageBox>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		JSONArray arr = new JSONArray();
		for (int i = 0; i < 5; i++) {
			JSONObject obj = JSONObject.fromObject(list.get(i));
			arr.add(obj);
		}
		// System.out.println(JSONArray.fromObject(list));
		return arr.toString();
	}

	/**
	 * 使用StringBuffer输出json格式字符串，属于技巧的方法，没用到json包
	 * 
	 * @return
	 */
	public String method09() {
		MessageBox m1 = new MessageBox(1, "消息1", "好消息1", "");
		MessageBox m2 = new MessageBox(2, "消息2", "好消息2", "");
		MessageBox m3 = new MessageBox(3, "消息3", "好消息3", "");
		MessageBox m4 = new MessageBox(4, "消息4", "好消息4", "");
		MessageBox m5 = new MessageBox(5, "消息5", "好消息5", "");
		List<MessageBox> list = new ArrayList<MessageBox>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			// ,{'title': '','msg': 'msg'}
			sb.append(",{'title': ").append(list.get(i).getTitle()).append(
					",'msg':").append(list.get(i).getMsg()).append("}");
		}
		return "[" + (sb.length() > 1 ? sb.substring(1) : "") + "]";
	}

	public static void main(String[] args) {
		Demo d = new Demo();
		// d.method06();
		String str = "[{'name':'json', 'age':'19', 'sex':'男', 'height':'200cm'},"
				+ "{'name':'json1', 'age':'10', 'sex':'男', 'height':'210cm'}]";
		JsonConfig js = new JsonConfig();
		js.setExcludes(new String[]{"age"});
		List<Student> list = JSONArray.toList(JSONArray.fromObject(str),
				new Student(), js);
		System.out.println(((Student) list.get(0)).toString());
	}

	// 10. list<Bean> 转换成json代码 JSONArray
	@SuppressWarnings("unchecked")
	@Test
	public void method10() {
		Student stu1 = new Student("json", 24);
		Student stu2 = new Student("json2", 24);
		Student stu3 = new Student("json3", 24);
		Student stu4 = new Student("json4", 24);
		Student stu5 = new Student("json5", 24);
		List list = new ArrayList();
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(stu4);
		list.add(stu5);
		JSONArray arr = JSONArray.fromObject(list);
		System.out.println(arr.toString());
	}
}
