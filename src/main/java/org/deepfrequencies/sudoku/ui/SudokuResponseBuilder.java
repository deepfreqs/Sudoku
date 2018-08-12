package org.deepfrequencies.sudoku.ui;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.deepfrequencies.sudoku.Definitions;
import org.deepfrequencies.sudoku.calculators.JustCalculateOptionsStrategy;
import org.deepfrequencies.sudoku.calculators.ObviousSinglesStrategy;
import org.deepfrequencies.sudoku.domain.SudokuPlayground;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SudokuResponseBuilder {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="justCalculateOptionsStrategy")	
	JustCalculateOptionsStrategy justCalculateOptionsStrategy;
	@Resource(name="obviousSinglesStrategy")	
	ObviousSinglesStrategy obviousSinglesStrategy;

	public static SudokuResponseBuilder getBuilder() {
		return new SudokuResponseBuilder();
	}

	public SudokuForm newSudokuForm() {
		return new SudokuForm(Definitions.EMPTYPLAYGROUND);
	}

	public SudokuForm takeAStep(SudokuForm sudokuForm) {
		SudokuPlayground ground = new SudokuPlayground(sudokuForm.exportToString());
		justCalculateOptionsStrategy.applyStrategy(ground);
		sudokuForm = new SudokuForm(ground);
    	return sudokuForm;
	}

	public SudokuForm loadFromString(String toLoad) {
		SudokuForm form;
		if (toLoad.isEmpty())
			form = new SudokuForm(Definitions.EMPTYPLAYGROUND);
		else
			form = new SudokuForm(toLoad);
		return form;
	}

	public SudokuForm tryToSolve(SudokuForm sudokuForm) {
		SudokuPlayground ground = new SudokuPlayground(sudokuForm.exportToString());
		SudokuPlayground formerGround = new SudokuPlayground(Definitions.EMPTYPLAYGROUND);
		int i = 1;
		while (!ground.isSolved() && ! ground.equals(formerGround) && i < 500) {
			formerGround = ground.copy();
			ground = ground.copy(); //?????? warum?
			obviousSinglesStrategy.applyStrategy(ground);
			logger.info("playground after obviousSinglesStrategy " + i + " iteration----------\n");
			logger.info(ground.toString());
			i+=1;
		}
		sudokuForm = new SudokuForm(ground);
    	return sudokuForm;
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
