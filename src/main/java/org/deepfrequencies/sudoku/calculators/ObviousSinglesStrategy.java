package org.deepfrequencies.sudoku.calculators;

import org.deepfrequencies.sudoku.domain.SudokuPlayground;

/**
 * If there is one option in a cell in a row / column / sector which cant be
 * found in another cell in a row / column / sector then its a hit.
 * 
 * @author markus
 */
public class ObviousSinglesStrategy extends AbstractStrategy {

	/**
	 * For every cell for every option check if the touched row / column / sector 
	 * contains this option only once: then its a single.
	 * And then the other options of this cell in this row / column / sector can be deleted.
	 * So its an algorithm which works on row / column / sector.
	 * 
	 * @param applyTo The playground on which the strategy is applied.
	 */
	SudokuPlayground ground;
	@Override
	public void applyStrategy(SudokuPlayground applyTo) {
		applyTo.clearOptions();
		applyTo.calculateOptions();
		applyTo.setSingleOptionsAsValues();
	}
}
