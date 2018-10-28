package org.deepfrequencies.sudoku.calculators;

import org.deepfrequencies.sudoku.domain.SudokuPlayground;

public abstract class AbstractStrategy {

	String name;

	public abstract void applyStrategy(SudokuPlayground applyTo);
	
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