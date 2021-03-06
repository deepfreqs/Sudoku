package org.deepfrequencies.sudoku.calculators;

import org.deepfrequencies.sudoku.domain.SudokuPlayground;

/**
 * Its not a real strategy, mere a precondition for applying strategies.
 * But it already finds the simplest singles, so it fits.
 * @author markus
 *
 */
public class JustCalculateOptionsStrategy extends AbstractStrategy {

	@Override
	public void applyStrategy(SudokuPlayground applyTo) {
		applyTo.calculateOptions();
	}

}
