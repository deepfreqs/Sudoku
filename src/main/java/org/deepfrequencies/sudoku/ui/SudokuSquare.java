package org.deepfrequencies.sudoku.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SudokuSquare {
	String a1;
	String a2;
	String a3;
	String b1;
	String b2;
	String b3;
	String c1;
	String c2;
	String c3;
	
	Map<String, HashMap<String, String>> options = new HashMap<String,HashMap<String,String>>();

	public String getA1() {
		return a1;
	}
	public void setA1(String a1) {
		this.a1 = a1;
	}
	public String getA2() {
		return a2;
	}
	public void setA2(String a2) {
		this.a2 = a2;
	}
	public String getA3() {
		return a3;
	}
	public void setA3(String a3) {
		this.a3 = a3;
	}
	public String getB1() {
		return b1;
	}
	public void setB1(String b1) {
		this.b1 = b1;
	}
	public String getB2() {
		return b2;
	}
	public void setB2(String b2) {
		this.b2 = b2;
	}
	public String getB3() {
		return b3;
	}
	public void setB3(String b3) {
		this.b3 = b3;
	}
	public String getC1() {
		return c1;
	}
	public void setC1(String c1) {
		this.c1 = c1;
	}
	public String getC2() {
		return c2;
	}
	public void setC2(String c2) {
		this.c2 = c2;
	}
	public String getC3() {
		return c3;
	}
	public void setC3(String c3) {
		this.c3 = c3;
	}
	
	public void removeNullValues() {
		a1 = " ".equals(a1)?null:a1;
		a2 = " ".equals(a2)?null:a2;
		a3 = " ".equals(a3)?null:a3;
		b1 = " ".equals(b1)?null:b1;
		b2 = " ".equals(b2)?null:b2;
		b3 = " ".equals(b3)?null:b3;
		c1 = " ".equals(c1)?null:c1;
		c2 = " ".equals(c2)?null:c2;
		c3 = " ".equals(c3)?null:c3;
	}

	
	
	public Map<String, HashMap<String, String>> getOptions() {
		return options;
	}
	public void setOptions(Map<String, HashMap<String, String>> options) {
		this.options = options;
	}
	public void addOption(String key, String[] values) {
		HashMap<String, String> valueMap = new HashMap<String, String>();
		for(String value : values) {
			valueMap.put(value, value);
		}
		options.put(key, valueMap);
	}
	
	@Override
	public String toString() {
		return this.a1 + "." + b1 + "." +  c1 + "\n" + a2 + "." + b2 + "." + c2 + "\n" + a3 + "." + b3 + "." + c3;
	}
	}
