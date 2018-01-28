package org.deepfrequencies.sudoku.ui;

import java.util.HashMap;
import java.util.Map;

public class SudokuResponseBuilder {
	public static SudokuResponseBuilder getBuilder() {
		return new SudokuResponseBuilder();
	}
	
	public Map<String,Object> createSudokuUI() {
    	HashMap<String,Object> variables = new HashMap<String,Object>();
    	variables.put("sudokuForm", new SudokuForm());
    	System.out.println(variables.toString());
    	return variables;

	}

}
