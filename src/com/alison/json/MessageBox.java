package com.alison.json;

import net.sf.json.JSONObject;

public class MessageBox {
	// 消息的id
	private int id;
	// 消息标题
	private String title;
	// 消息信息
	private String msg;
	// 消息的回调函数
	private String callback;
	// 消息的扩展信息
	private Object jsonExt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public Object getJsonExt() {
		return jsonExt;
	}

	public void setJsonExt(Object jsonExt) {
		this.jsonExt = jsonExt;
	}

	// 输出为json格式的字符串
	public String toJson() {
		return JSONObject.fromObject(this).toString();
	}

	public MessageBox(int id, String title, String msg, String callback) {
		super();
		this.id = id;
		this.title = title;
		this.msg = msg;
		this.callback = callback;
	}

	public MessageBox() {
		super();
	}

}
