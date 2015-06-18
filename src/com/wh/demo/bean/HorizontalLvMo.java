package com.wh.demo.bean;

/**
 * 横向滚动listView的数据
 * 
 * @author hujiushou
 * 
 */
public class HorizontalLvMo {

	private int dra;
	private String dec;

	public HorizontalLvMo(int dra, String dec) {
		this.dra = dra;
		this.dec = dec;
	}

	public int getDra() {
		return dra;
	}

	public void setDra(int dra) {
		this.dra = dra;
	}

	public String getDec() {
		return dec;
	}

	public void setDec(String dec) {
		this.dec = dec;
	}
}
