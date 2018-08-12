package org.deepfrequencies.sudoku.calculators;

import org.deepfrequencies.sudoku.Definitions;
import org.deepfrequencies.sudoku.domain.SudokuPlayground;
import org.junit.Test;

import junit.framework.TestCase;

public class JustCalculateOptionsStrategyTest extends TestCase{

	private JustCalculateOptionsStrategy createTestSubject() {
		return new JustCalculateOptionsStrategy();
	}

	@Test
	public void testApplyStrategy() throws Exception {
		JustCalculateOptionsStrategy testSubject;
		SudokuPlayground applyTo = new SudokuPlayground(Definitions.EMPTYPLAYGROUND);

		// default test
		testSubject = createTestSubject();
		testSubject.applyStrategy(applyTo);
	}
}