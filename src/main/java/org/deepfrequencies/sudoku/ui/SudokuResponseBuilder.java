package org.deepfrequencies.sudoku.ui;

import java.util.HashMap;
import java.util.Map;

import org.deepfrequencies.sudoku.calculators.SimpleNextStepStrategy;
import org.deepfrequencies.sudoku.domain.SudokuPlayground;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SudokuResponseBuilder {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static final String EMPTYPLAYGROUND = "000000000000000000000000000000000000000000000000000000000000000000000000000000000";

	public static SudokuResponseBuilder getBuilder() {
		return new SudokuResponseBuilder();
	}
	
	public SudokuForm newSudokuForm() {
		return new SudokuForm(EMPTYPLAYGROUND);
	}

	public SudokuForm takeAStep(SudokuForm sudokuForm) {
		SudokuPlayground ground = new SudokuPlayground(sudokuForm.exportToString());
		SimpleNextStepStrategy.applyStrategy(ground);
		sudokuForm = new SudokuForm(ground);
    	return sudokuForm;//.removeNullValues(); //do i still need this?
	}

	public SudokuForm removeNullValues(SudokuForm sudokuForm) {
    	return sudokuForm.removeNullValues();
	}

	public SudokuForm loadFromString(String toLoad) {
		SudokuForm form;
		if (toLoad.isEmpty())
			form = new SudokuForm(EMPTYPLAYGROUND);
		else
			form = new SudokuForm(toLoad);
		return form;
	}

	public Map<String,Object> createModelMap() {
    	HashMap<String,Object> variables = new HashMap<>();
    	variables.put("sudokuForm", new SudokuForm());
    	if (logger.isInfoEnabled()) {
        	logger.info(variables.toString());
    	}
    	return variables;
	}

}
