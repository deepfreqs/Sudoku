package org.deepfrequencies.sudoku.ui;

import java.util.HashMap;
import java.util.Map;

public class SudokuResponseBuilder {
	private SudokuForm sudokuForm;
	
	public static SudokuResponseBuilder getBuilder() {
		return new SudokuResponseBuilder();
	}
	
	public SudokuForm newSudokuForm() {
    	return new SudokuForm("300401076602500040000006210500000180700010002021000007054300000090004608830109004");
	}

	public SudokuForm calculateNextStep(SudokuForm sudokuForm) {
    	return sudokuForm.removeNullValues();
	}

	public SudokuForm removeNullValues(SudokuForm sudokuForm) {
    	return sudokuForm.removeNullValues();
	}

	public SudokuForm loadFromString(String toLoad) {
		return new SudokuForm(toLoad);
	}
	public Map<String,Object> createModelMap() {
    	HashMap<String,Object> variables = new HashMap<String,Object>();
    	variables.put("sudokuForm", new SudokuForm());
    	System.out.println(variables.toString());
    	return variables;
	}

}
