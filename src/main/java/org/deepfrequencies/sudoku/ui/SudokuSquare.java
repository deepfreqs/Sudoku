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

	SudokuSquare (){
		
	}
	
	SudokuSquare (String line1, String line2, String line3){
		setA1(line1.substring(0, 1));
		setB1(line1.substring(1, 2));
		setC1(line1.substring(2, 3));
		setA2(line2.substring(0, 1));
		setB2(line2.substring(1, 2));
		setC2(line2.substring(2, 3));
		setA3(line3.substring(0, 1));
		setB3(line3.substring(1, 2));
		setC3(line3.substring(2, 3));
	}
	
	public String getA1() {
		return a1;
	}
	public void setA1(String a1) {
		if (isNullValue(a1)) 
			this.addOption("A1", new String[] {" ", "1", "3", "4", "5", "7", "8", "9"});
		this.a1 = isNullValue(a1)?"12345":a1;
	}
	public String getA2() {
		return a2;
	}
	public void setA2(String a2) {
		if (isNullValue(a2)) 
			this.addOption("A2", new String[] {" ", "1", "3", "4", "5", "7", "8", "9"});
		this.a2 = isNullValue(a2)?null:a2;
	}
	public String getA3() {
		return a3;
	}
	public void setA3(String a3) {
		if (isNullValue(a3)) 
			this.addOption("A3", new String[] {" ", "1", "3", "4", "5", "7", "8", "9"});
		this.a3 = isNullValue(a3)?null:a3;
	}
	public String getB1() {
		return b1;
	}
	public void setB1(String b1) {
		if (isNullValue(b1)) 
			this.addOption("B1", new String[] {" ", "1", "3", "4", "5", "7", "8", "9"});
		this.b1 = isNullValue(b1)?"94757":b1;
	}
	public String getB2() {
		return b2;
	}
	public void setB2(String b2) {
		if (isNullValue(b2)) 
			this.addOption("B2", new String[] {" ", "1", "3", "4", "5", "7", "8", "9"});
		this.b2 = isNullValue(b2)?null:b2;
	}
	public String getB3() {
		return b3;
	}
	public void setB3(String b3) {
		if (isNullValue(b3)) 
			this.addOption("B3", new String[] {" ", "1", "3", "4", "5", "7", "8", "9"});
		this.b3 = isNullValue(b3)?null:b3;
	}
	public String getC1() {
		return c1;
	}
	public void setC1(String c1) {
		if (isNullValue(c1)) 
			this.addOption("C1", new String[] {" ", "1", "3", "4", "5", "7", "8", "9"});
		this.c1 = isNullValue(c1)?null:c1;
	}
	public String getC2() {
		return c2;
	}
	public void setC2(String c2) {
		if (isNullValue(c2)) 
			this.addOption("C2", new String[] {" ", "1", "3", "4", "5", "7", "8", "9"});
		this.c2 = isNullValue(c2)?null:c2;
	}
	public String getC3() {
		return c3;
	}
	public void setC3(String c3) {
		if (isNullValue(c3)) 
			this.addOption("C3", new String[] {" ", "1", "3", "4", "5", "7", "8", "9"});
		this.c3 = isNullValue(c3)?null:c3;
	}
	
	public void removeNullValues() {
		a1 = isNullValue(a1)?null:a1;
		a2 = isNullValue(a2)?null:a2;
		a3 = isNullValue(a3)?null:a3;
		b1 = isNullValue(b1)?null:b1;
		b2 = isNullValue(b2)?null:b2;
		b3 = isNullValue(b3)?null:b3;
		c1 = isNullValue(c1)?null:c1;
		c2 = isNullValue(c2)?null:c2;
		c3 = isNullValue(c3)?null:c3;
	}

	private boolean isNullValue(String s) {
		return (" ".equals(s) || "0".equals(s) || "*".equals(s) || ".".equals(s)) == true;
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
		return this.a1 + "|" + b1 + "|" +  c1 + "\n" + a2 + "|" + b2 + "|" + c2 + "\n" + a3 + "|" + b3 + "|"+ c3;
	}
	}
