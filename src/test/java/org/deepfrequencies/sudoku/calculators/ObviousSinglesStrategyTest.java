package org.deepfrequencies.sudoku.calculators;

import org.deepfrequencies.sudoku.Definitions;
import org.deepfrequencies.sudoku.domain.SudokuPlayground;
import org.junit.Test;

import junit.framework.TestCase;

public class ObviousSinglesStrategyTest extends TestCase{

	private ObviousSinglesStrategy createTestSubject() {
		return new ObviousSinglesStrategy();
	}

	@Test
	public void testApplyStrategy() throws Exception {
		ObviousSinglesStrategy testSubject;
		SudokuPlayground applyTo = new SudokuPlayground(Definitions.EMPTYPLAYGROUND);

		// default test
		testSubject = createTestSubject();
		testSubject.applyStrategy(applyTo);
	}
}