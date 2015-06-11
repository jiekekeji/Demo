package com.wh.demo.bean;

public class AcInfo {

	private String acDec;

	private Class<?> cls;

	public AcInfo(String acDec, Class<?> cls) {
		this.acDec = acDec;
		this.cls = cls;
	}

	public String getAcDec() {
		return acDec;
	}

	public void setAcDec(String acDec) {
		this.acDec = acDec;
	}

	public Class<?> getCls() {
		return cls;
	}

	public void setCls(Class<?> cls) {
		this.cls = cls;
	}

}
