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
		this.a1 = isNullValue(a1)?"12345":a1;
	}
	public String getA2() {
		return a2;
	}
	public void setA2(String a2) {
		this.a2 = isNullValue(a2)?"12345":a2;
	}
	public String getA3() {
		return a3;
	}
	public void setA3(String a3) {
		this.a3 = isNullValue(a3)?"12345":a3;
	}
	public String getB1() {
		return b1;
	}
	public void setB1(String b1) {
		this.b1 = isNullValue(b1)?"94757":b1;
	}
	public String getB2() {
		return b2;
	}
	public void setB2(String b2) {
		this.b2 = isNullValue(b2)?"12345":b2;
	}
	public String getB3() {
		return b3;
	}
	public void setB3(String b3) {
		this.b3 = isNullValue(b3)?"12345":b3;
	}
	public String getC1() {
		return c1;
	}
	public void setC1(String c1) {
		this.c1 = isNullValue(c1)?"12345":c1;
	}
	public String getC2() {
		return c2;
	}
	public void setC2(String c2) {
		this.c2 = isNullValue(c2)?"1 2 3\n4 5 6\n7 8 9":c2;
	}
	public String getC3() {
		return c3;
	}
	public void setC3(String c3) {
		this.c3 = isNullValue(c3)?"12345":c3;
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
	
	
	@Override
	public String toString() {
		return this.a1 + "|" + b1 + "|" +  c1 + "\n" + a2 + "|" + b2 + "|" + c2 + "\n" + a3 + "|" + b3 + "|"+ c3;
	}
}
