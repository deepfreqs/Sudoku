package org.deepfrequencies.sudoku.calculators;

import java.util.Collection;
import org.deepfrequencies.sudoku.domain.SudokuCell;
import org.deepfrequencies.sudoku.domain.SudokuPlayground;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Its not a real strategy, mere a precondition for applying strategies.
 * But it already finds the simplest singles, so it fits.
 * @author markus
 *
 */
public class JustCalculateOptionsStrategy extends AbstractStrategy {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void applyStrategy(SudokuPlayground applyTo) {
		applyTo.calculateOptions();
	}

}
