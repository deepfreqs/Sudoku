package org.deepfrequencies.sudoku.calculators;

import java.util.Collection;
import org.deepfrequencies.sudoku.domain.SudokuCell;
import org.deepfrequencies.sudoku.domain.SudokuPlayground;


public class SimpleNextStepStrategy {
	
	private SimpleNextStepStrategy() {
		
	}
	public static void applyStrategy(SudokuPlayground applyTo) {
		Collection<SudokuCell> cells = applyTo.getCells();
		for (SudokuCell cell : (Collection<SudokuCell>) cells) {
			for(int i = 1; i <= 9; i++) {
				if (! cell.getRow().contains(i) &&
					! cell.getColumn().contains(i) &&
					! cell.getSector().contains(i)) {
					cell.addOption(i);
				}
			}
		}
	}

}
