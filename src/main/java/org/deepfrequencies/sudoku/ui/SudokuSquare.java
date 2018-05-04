package org.deepfrequencies.sudoku.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
	
	Map<String,Boolean> nulls = new HashMap<>();

	private static final String INITPATTERN = "1 2 3\n4 5 6\n7 8 9";
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
		this.a1 = isNullValue(a1) ? INITPATTERN: a1;
		nulls.put("a1",  isNullValue(a1));
	}
	public void setA1Options(List<Integer> options) {
		this.a1 = this.makeCellContent(a1, options);
	}
	public String getA2() {
		return a2;
	}
	public void setA2(String a2) {
		this.a2 = isNullValue(a2) ? INITPATTERN: a2;
		nulls.put("a2",  isNullValue(a2));
	}
	public void setA2Options(List<Integer> options) {
		this.a2 = this.makeCellContent(a2, options);
	}
	public String getA3() {
		return a3;
	}
	public void setA3(String a3) {
		this.a3 = isNullValue(a3) ? INITPATTERN: a3;
		nulls.put("a3",  isNullValue(a3));
	}
	public void setA3Options(List<Integer> options) {
		this.a3 = this.makeCellContent(a3, options);
	}

	public String getB1() {
		return b1;
	}
	public void setB1(String b1) {
		this.b1 = isNullValue(b1) ? INITPATTERN: b1;
		nulls.put("b1",  isNullValue(b1));
	}
	public void setB1Options(List<Integer> options) {
		this.b1 = this.makeCellContent(b1, options);
	}
	
	public String getB2() {
		return b2;
	}
	public void setB2(String b2) {
		this.b2 = isNullValue(b2) ? INITPATTERN: b2;
		nulls.put("b2",  isNullValue(b2));
	}
	public void setB2Options(List<Integer> options) {
		this.b2 = this.makeCellContent(b2, options);
	}
	
	public String getB3() {
		return b3;
	}
	public void setB3(String b3) {
		this.b3 = isNullValue(b3) ? INITPATTERN: b3;
		nulls.put("b3",  isNullValue(b3));
	}
	public void setB3Options(List<Integer> options) {
		this.b3 = this.makeCellContent(b3, options);
	}

	public String getC1() {
		return c1;
	}
	public void setC1(String c1) {
		this.c1 = isNullValue(c1) ? INITPATTERN: c1;
		nulls.put("c1",  isNullValue(c1));
	}
	public void setC1Options(List<Integer> options) {
		this.c1 = this.makeCellContent(c1, options);
	}
	
	public String getC2() {
		return c2;
	}
	public void setC2(String c2) {
		this.c2 = isNullValue(c2) ? INITPATTERN: c2;
		nulls.put("c2",  isNullValue(c2));
	}
	public void setC2Options(List<Integer> options) {
		this.c2 = this.makeCellContent(c2, options);
	}
	
	public String getC3() {
		return c3;
	}
	public void setC3(String c3) {
		this.c3 = isNullValue(c3) ? INITPATTERN: c3;
		nulls.put("c3",  isNullValue(c3));
	}
	public void setC3Options(List<Integer> options) {
		this.c3 = this.makeCellContent(c3, options);
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
		//length check implies that if we cant distinguish between a real chosen value or
		//a cell with only one option (in this case it is seen as "chosen by user"
		return (" ".equals(s) || "0".equals(s) || "*".equals(s) || ".".equals(s)) || s.length()>1;
	}
	
	public String getRowForExport(int index) {
		if (index == 1)
			return (nulls.get("a1")?"0":a1) + (nulls.get("b1")?"0":b1) + (nulls.get("c1")?"0":c1);
		if (index == 2)
			//return a2+b2+c2;
			return (nulls.get("a2")?"0":a2) + (nulls.get("b2")?"0":b2) + (nulls.get("c2")?"0":c2);
		if (index == 3)
			return (nulls.get("a3")?"0":a3) + (nulls.get("b3")?"0":b3) + (nulls.get("c3")?"0":c3);
		return null;
	}
	
	public String makeCellContent(String value, List<Integer> options) {
		String result = value;
		if (isNullValue(result)) {
			if (options == null || options.isEmpty()) {
				result = INITPATTERN;
			} else {
				result = options.stream().map(i -> i % 3 != 0 ? i + " " : i + "\n").collect(Collectors.joining());
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		return this.a1 + "|" + b1 + "|" +  c1 + "\n" + a2 + "|" + b2 + "|" + c2 + "\n" + a3 + "|" + b3 + "|"+ c3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a1 == null) ? 0 : a1.hashCode());
		result = prime * result + ((a2 == null) ? 0 : a2.hashCode());
		result = prime * result + ((a3 == null) ? 0 : a3.hashCode());
		result = prime * result + ((b1 == null) ? 0 : b1.hashCode());
		result = prime * result + ((b2 == null) ? 0 : b2.hashCode());
		result = prime * result + ((b3 == null) ? 0 : b3.hashCode());
		result = prime * result + ((c1 == null) ? 0 : c1.hashCode());
		result = prime * result + ((c2 == null) ? 0 : c2.hashCode());
		result = prime * result + ((c3 == null) ? 0 : c3.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		// here we should take care of null values
		return true;
		/*
		SudokuSquare other = (SudokuSquare) obj;
		if (a1 == null) {
			if (other.a1 != null)
				return false;
		} else if (!a1.equals(other.a1))
			return false;
		if (a2 == null) {
			if (other.a2 != null)
				return false;
		} else if (!a2.equals(other.a2))
			return false;
		if (a3 == null) {
			if (other.a3 != null)
				return false;
		} else if (!a3.equals(other.a3))
			return false;
		if (b1 == null) {
			if (other.b1 != null)
				return false;
		} else if (!b1.equals(other.b1))
			return false;
		if (b2 == null) {
			if (other.b2 != null)
				return false;
		} else if (!b2.equals(other.b2))
			return false;
		if (b3 == null) {
			if (other.b3 != null)
				return false;
		} else if (!b3.equals(other.b3))
			return false;
		if (c1 == null) {
			if (other.c1 != null)
				return false;
		} else if (!c1.equals(other.c1))
			return false;
		if (c2 == null) {
			if (other.c2 != null)
				return false;
		} else if (!c2.equals(other.c2))
			return false;
		if (c3 == null) {
			if (other.c3 != null)
				return false;
		} else if (!c3.equals(other.c3))
			return false;
		return true;
		*/
	}
	
	
}
