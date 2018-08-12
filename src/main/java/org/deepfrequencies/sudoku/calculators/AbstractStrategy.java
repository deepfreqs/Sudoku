package org.deepfrequencies.sudoku.calculators;

import org.deepfrequencies.sudoku.domain.SudokuPlayground;

abstract public class AbstractStrategy {

	String name;

	abstract public void applyStrategy(SudokuPlayground applyTo);
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AbstractStrategy() {
		super();
	}

}