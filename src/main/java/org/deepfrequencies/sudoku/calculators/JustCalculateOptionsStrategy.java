package org.deepfrequencies.sudoku.calculators;

import java.util.Collection;
import org.deepfrequencies.sudoku.domain.SudokuCell;
import org.deepfrequencies.sudoku.domain.SudokuPlayground;

/**
 * Its not a real strategy, mere a precondition for applying strategies.
 * But it already finds the simplest singles, so it fits.
 * @author markus
 *
 */
public class JustCalculateOptionsStrategy extends AbstractStrategy {
	

	public void applyStrategy(SudokuPlayground applyTo) {
		Collection<SudokuCell> cells = applyTo.getCells();
		for (SudokuCell cell : (Collection<SudokuCell>) cells) {
			//die Optionen stimmen nicht, daher dachte ich: Optionen nur setzen,
			//wenn die Zelle einen Wert hat; aber jetzt funktioniert die Just..Strategie nicht??
			for(int i = 1; i <= 9; i++) {
				if (cell.getValue() == 0 &&
					! cell.getRow().contains(i) &&
					! cell.getColumn().contains(i) &&
					! cell.getSector().contains(i)) {
					cell.addOption(i);
				}
			}
		}
	}

}
