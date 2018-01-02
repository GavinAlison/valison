package com.alison.base.class5.enums;

public enum Week {
	MON("1"), TUE("2"), WEN("3"), THU("4"), FAR("5"), SAT("6"), SUN("7");
	private String var;

	Week(String str) {
		this.var = str;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

}
