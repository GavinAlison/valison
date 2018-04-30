package com.alison.json;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Before;
import org.junit.Test;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONFunction;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.PropertyFilter;
import net.sf.json.xml.XMLSerializer;

/**
 * 利用json-lib将java对象转换成JSON字符串
 * <ref>https://blog.csdn.net/tanga842428/article/details/54864485<ref>
 * 
 * @author hy
 *
 */
public class JsonUtil {
	private Student2 bean = null;
	private JSONObject jsonObject = null;
	private JSONArray jsonArray = null;

	@SuppressWarnings("rawtypes")
	@Before
	public void init() {
		jsonObject = new JSONObject();
		jsonArray = new JSONArray();
		bean = new Student2();
		bean.setAddress("address1");
		bean.setEmail("email1");
		bean.setId(1);
		bean.setName("asd1");
		Birthday day = new Birthday();
		day.setBirthday("2010-11-22");
		bean.setBirthday(day);
	}

	/**
	 * Java Bean对象到JSON<br>
	 * 
	 */
	@Test
	public void writeEntity2JSON() {
		System.out.println("==============Java Bean >>> JSON Object==================");
		String jsonbeanStr = JSONObject.fromObject(bean).toString();
		System.out.println(jsonbeanStr);
		System.out.println("==============Java Bean >>> JSON Array==================");
		jsonbeanStr = JSONArray.fromObject(bean).toString();// array会在最外层套上[]
		System.out.println(jsonbeanStr);
		System.out.println("==============Java Bean >>> JSON Array==================");
		jsonbeanStr = JSONSerializer.toJSON(bean).toString();
		System.out.println(jsonbeanStr);
		System.out.println("========================JsonConfig========================");
		// 过滤属性与处理属性的值
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Birthday.class, new JsonValueProcessor() {
			public Object processArrayValue(Object value, JsonConfig jsonConfig) {
				if (value == null) {
					return new Date();
				}
				return value;
			}

			public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
				System.out.println("key:" + key);
				return value + "##修改过的日期";
			}

		});
		bean.setBirthday(null);
		jsonObject = JSONObject.fromObject(bean, jsonConfig);
		System.out.println(jsonObject.toString());
		System.out.println("==============Java Object >>> JSON Bean==================");
		// 将JSON对象转换成bean
		Student2 student = (Student2) JSONObject.toBean(jsonObject, Student2.class);
		System.out.println(jsonObject);
		System.out.println(jsonObject.getString("birthday"));
		System.out.println(student.toString());
		System.out.println("#####################JsonPropertyFilter############################");
		// 属性过滤
		jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
			public boolean apply(Object source, String name, Object value) {
				System.out.println(name + "--" + value);
				// 忽略birthday属性
				if (value != null && Birthday.class.isAssignableFrom(value.getClass())) {
					return true;
				}
				return false;
			}
		});
		System.out.println(JSONObject.fromObject(bean, jsonConfig).toString());
		System.out.println("#################JavaPropertyFilter##################");
		jsonConfig.setRootClass(Student2.class);
		jsonConfig.setJavaPropertyFilter(new PropertyFilter() {
			public boolean apply(Object source, String name, Object value) {
				System.out.println(name + "@" + value);
				// 过滤掉id与email
				if ("id".equals(name) || "email".equals(name)) {
					return true;
				}
				return false;
			}
		});
		student = (Student2) JSONObject.toBean(jsonObject, jsonConfig);
		System.out.println("Student:" + student.toString());
	}

	/**
	 * Java List集合到JSON
	 */
	@Test
	public void writeList2JSON() {
		System.out.println("==============Java List >>> JSON Array==================");
		List<Student2> stu = new ArrayList<Student2>();
		stu.add(bean);
		bean.setName("jack");
		stu.add(bean);
		System.out.println(JSONArray.fromObject(stu).toString());
		System.out.println(JSONSerializer.toJSON(stu).toString());
	}

	/**
	 * Java Map对象到JSON<br>
	 * Map集合有JavaBean、String、Boolean、Integer、以及Array和js的function函数的字符串。
	 */
	@Test
	public void writeMap2JSON() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("A", bean);
		bean.setName("jack");
		map.put("B", bean);
		map.put("name", "json");
		map.put("bool", Boolean.TRUE);
		map.put("int", new Integer(1));
		map.put("arr", new String[] { "a", "b" });
		map.put("func", "function(i){ return this.arr[i]; }");
		System.out.println("==============Java Map >>> JSON Object==================");
		System.out.println(JSONObject.fromObject(map).toString());
		System.out.println("==============Java Map >>> JSON Array ==================");
		System.out.println(JSONArray.fromObject(map).toString());
		System.out.println("==============Java Map >>> JSON Object==================");
		System.out.println(JSONSerializer.toJSON(map).toString());
	}

	/**
	 * 将更多类型转换成JSON
	 */
	@Test
	public void writeObject2JSON() {
		String[] sa = { "a", "b", "c" };
		System.out.println("==============Java StringArray >>> JSON Array ==================");
		System.out.println(JSONArray.fromObject(sa).toString());
		System.out.println(JSONSerializer.toJSON(sa).toString());
		System.out.println("==============Java boolean Array >>> JSON Array ==================");
		boolean[] bo = { true, false, true };
		System.out.println(JSONArray.fromObject(bo).toString());
		System.out.println(JSONSerializer.toJSON(bo).toString());
		Object[] o = { 1, "a", true, 'A', sa, bo };
		System.out.println("==============Java Object Array >>> JSON Array ==================");
		System.out.println(JSONArray.fromObject(o).toString());
		System.out.println(JSONSerializer.toJSON(o).toString());
		System.out.println("==============Java String >>> JSON ==================");
		System.out.println(JSONArray.fromObject("['json','is','easy']").toString());
		System.out.println(JSONObject.fromObject("{'json':'is easy'}").toString());
		System.out.println(JSONSerializer.toJSON("['json','is','easy']").toString());
		System.out.println("==============Java JSONObject >>> JSON ==================");
		jsonObject = new JSONObject().element("string", "JSON").element("integer", "1").element("double", "2.0")
				.element("boolean", "true");
		System.out.println(JSONSerializer.toJSON(jsonObject).toString());

		System.out.println("==============Java JSONArray >>> JSON ==================");
		jsonArray = new JSONArray().element("JSON").element("1").element("2.0").element("true");
		System.out.println(JSONSerializer.toJSON(jsonArray).toString());

		System.out.println("==============Java JSONArray JsonConfig#setArrayMode >>> JSON ==================");
		List input = new ArrayList();
		input.add("JSON");
		input.add("1");
		input.add("2.0");
		input.add("true");
		JSONArray jsonArray = (JSONArray) JSONSerializer.toJSON(input);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setArrayMode(JsonConfig.MODE_OBJECT_ARRAY);
		Object[] output = (Object[]) JSONSerializer.toJava(jsonArray, jsonConfig);
		System.out.println(output[0]);

		/**
		 * 这里还有一个JSONFunction的对象，可以转换JavaScript的function。可以获取方法参数和方法体。同时，
		 * 还可以用JSONObject、JSONArray构建Java对象，完成Java对象到JSON字符串的转换。
		 */
		System.out.println("==============Java JSONFunction >>> JSON ==================");
		String str = "{'func': function( param1 ){ doSomethingWithParam(param2); }}";
		JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(str);
		JSONFunction func = (JSONFunction) jsonObject.get("func");
		System.out.println(func.getParams()[0]);
		System.out.println(func.getText());
	}

	private String json = "{\"address\":\"chian\",\"birthday\":{\"birthday\":\"2010-11-22\"},"
			+ "\"email\":\"email@123.com\",\"id\":22,\"name\":\"tom\"}";

	/**
	 * JSON对象反序列化成Java对象<br>
	 * 将json字符串转成Java对象
	 */
	@Test
	public void readJSON2Bean() {
		System.out.println("==============JSON Object String >>> Java Bean ==================");
		jsonObject = JSONObject.fromObject(json);
		Student stu = (Student) JSONObject.toBean(jsonObject, Student.class);
		System.out.println(stu.toString());
	}

	/**
	 * 将json字符串转换成动态Java对象(MorphDynaBean)
	 */
	@Test
	public void readJSON2DynaBean() {
		try {
			System.out.println("==============JSON Object String >>> Java MorphDynaBean ==================");
			JSON jo = JSONSerializer.toJSON(json);
			Object o = JSONSerializer.toJava(jo);// MorphDynaBean
			System.out.println(PropertyUtils.getProperty(o, "address").toString());
			jsonObject = JSONObject.fromObject(json);
			System.out.println(jsonObject.getString("email"));
			o = JSONSerializer.toJava(jsonObject);// MorphDynaBean
			System.out.println(PropertyUtils.getProperty(o, "name").toString());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将json字符串转成Java的Array数组
	 */
	@Test
	public void readJSON2Array() {
		try {
			System.out.println("==============JSON Arry String >>> Java Array ==================");
			json = "[" + json + "]";
			jsonArray = JSONArray.fromObject(json);
			System.out.println("#%%%" + jsonArray.get(0).toString());
			Object[] os = jsonArray.toArray();
			System.out.println(os.length);

			System.out.println(JSONArray.fromObject(json).join(""));
			System.out.println(os[0].toString());
			Student2[] stus = (Student2[]) JSONArray.toArray(jsonArray, Student2.class);
			System.out.println(stus.length);
			System.out.println(stus[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将JSON字符串转成Java的List集合
	 */
	@Test
	public void readJSON2List() {
		try {
			System.out.println("==============JSON Arry String >>> Java List ==================");
			json = "[" + json + "]";
			jsonArray = JSONArray.fromObject(json);
			List<Student2> list = JSONArray.toList(jsonArray, Student2.class);
			System.out.println(list.size());
			System.out.println(list.get(0));

			list = JSONArray.toList(jsonArray);
			System.out.println(list.size());
			System.out.println(list.get(0));// MorphDynaBean
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将json字符串转换成Collection接口
	 */
	@Test
	public void readJSON2Collection() {
		try {
			System.out.println("==============JSON Arry String >>> Java Collection ==================");
			json = "[" + json + "]";
			jsonArray = JSONArray.fromObject(json);
			Collection<Student> con = JSONArray.toCollection(jsonArray, Student.class);
			System.out.println(con.size());
			Object[] stt = con.toArray();
			System.out.println(stt.length);
			System.out.println(stt[0].toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将json字符串转换成Map集合
	 */
	@Test
	public void readJSON2Map() {
		try {
			System.out.println("==============JSON Arry String >>> Java Map ==================");
			json = "{\"arr\":[\"a\",\"b\"],\"A\":{\"address\":\"address\",\"birthday\":{\"birthday\":\"2010-11-22\"},"
					+ "\"email\":\"email\",\"id\":1,\"name\":\"jack\"},\"int\":1,"
					+ "\"B\":{\"address\":\"address\",\"birthday\":{\"birthday\":\"2010-11-22\"},"
					+ "\"email\":\"email\",\"id\":1,\"name\":\"jack\"},\"name\":\"json\",\"bool\":true}";
			jsonObject = JSONObject.fromObject(json);
			Map<String, Class<?>> clazzMap = new HashMap<String, Class<?>>();
			clazzMap.put("arr", String[].class);
			clazzMap.put("A", Student.class);
			clazzMap.put("B", Student.class);
			Map<String, ?> mapBean = (Map) JSONObject.toBean(jsonObject, Map.class, clazzMap);
			System.out.println(mapBean);

			Set<String> set = mapBean.keySet();
			Iterator<String> iter = set.iterator();
			while (iter.hasNext()) {
				String key = iter.next();
				System.out.println(key + ":" + mapBean.get(key).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将Java对象到XML<br>
	 * 需要额外的jar包：xom.jar
	 */
	@Test
	public void writeObject2XML() {
		XMLSerializer xmlSerializer = new XMLSerializer();
		System.out.println("==============Java String Array >>> XML ==================");
		// xmlSerializer.setElementName("bean");
		System.out.println(xmlSerializer.write(JSONArray.fromObject(bean)));
		String[] sa = { "a", "b", "c" };
		System.out.println("==============Java String Array >>> XML ==================");
		System.out.println(xmlSerializer.write(JSONArray.fromObject(sa)));
		System.out.println("==============Java boolean Array >>> XML ==================");
		boolean[] bo = { true, false, true };
		System.out.println(xmlSerializer.write(JSONArray.fromObject(bo)));
		System.out.println(xmlSerializer.write(JSONSerializer.toJSON(bo)));
		Object[] o = { 1, "a", true, 'A', sa, bo };
		System.out.println("==============Java Object Array >>> JSON Array ==================");
		System.out.println(xmlSerializer.write(JSONArray.fromObject(o)));
		System.out.println(xmlSerializer.write(JSONSerializer.toJSON(o)));
		System.out.println("==============Java String >>> JSON ==================");
		System.out.println(xmlSerializer.write(JSONArray.fromObject("['json','is','easy']")).toString());
		System.out.println(xmlSerializer.write(JSONObject.fromObject("{'json':'is easy'}")).toString());
		System.out.println(xmlSerializer.write(JSONSerializer.toJSON("['json','is','easy']")).toString());
	}

	/**
	 * 将XML转换成Java对象
	 */
	@Test
	public void readXML2Object() {
		XMLSerializer xmlSerializer = new XMLSerializer();
		System.out.println("============== XML >>>> Java String Array ==================");
		String[] sa = { "a", "b", "c" };
		jsonArray = (JSONArray) xmlSerializer.read(xmlSerializer.write(JSONArray.fromObject(sa)));
		System.out.println(jsonArray.toString());

		String[] s = (String[]) JSONArray.toArray(jsonArray, String.class);
		System.out.println(s[0].toString());

		System.out.println("============== XML >>>> Java boolean Array ==================");
		boolean[] bo = { true, false, true };
		jsonArray = (JSONArray) xmlSerializer.read(xmlSerializer.write(JSONArray.fromObject(bo)));
		bo = (boolean[]) JSONArray.toArray(jsonArray, boolean.class);
		System.out.println(bo.toString());
		System.out.println(bo[0]);

		jsonArray = (JSONArray) xmlSerializer.read(xmlSerializer.write(JSONSerializer.toJSON(bo)));
		bo = (boolean[]) JSONArray.toArray(jsonArray, boolean.class);
		System.out.println(bo.toString());
		System.out.println(bo[0]);

		System.out.println("==============Java Object Array >>> JSON Array ==================");
		Object[] o = { 1, "a", true, 'A', sa, bo };
		jsonArray = (JSONArray) xmlSerializer.read(xmlSerializer.write(JSONArray.fromObject(o)));
		System.out.println(jsonArray.getInt(0));
		System.out.println(jsonArray.get(1));
		System.out.println(jsonArray.getBoolean(2));
		jsonArray = (JSONArray) xmlSerializer.read(xmlSerializer.write(JSONSerializer.toJSON(o)));
		System.out.println(jsonArray.get(4));
		System.out.println(jsonArray.getJSONArray(5).get(0));
		System.out.println(jsonArray.get(5));

		System.out.println("==============Java String >>> JSON ==================");
		jsonArray = (JSONArray) xmlSerializer
				.read(xmlSerializer.write(JSONArray.fromObject("['json','is','easy']")).toString());
		s = (String[]) JSONArray.toArray(jsonArray, String.class);
		System.out.println(s[0].toString());
		jsonObject = (JSONObject) xmlSerializer
				.read(xmlSerializer.write(JSONObject.fromObject("{'json':'is easy'}")).toString());
		Object obj = JSONObject.toBean(jsonObject);
		System.out.println(obj);
		jsonArray = (JSONArray) xmlSerializer
				.read(xmlSerializer.write(JSONSerializer.toJSON("['json','is','easy']")).toString());
		s = (String[]) JSONArray.toArray(jsonArray, String.class);
		System.out.println(s[1].toString());
	}

	/**
	 * 将xml的字符串内容，转换成Java的Array对象
	 */
	@Test
	public void testReadXml2Array() {
		String str = "<a class=\"array\">" + "<e type=\"function\" params=\"i,j\">" + "return matrix[i][j];" + "</e>"
				+ "</a>";
		JSONArray json = (JSONArray) new XMLSerializer().read(str);
		System.out.println(json.toString());
	}
}
