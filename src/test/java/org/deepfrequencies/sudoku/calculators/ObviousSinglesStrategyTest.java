package org.deepfrequencies.sudoku.calculators;

import static org.junit.Assert.*;
import java.util.*;

import org.deepfrequencies.sudoku.Definitions;
import org.deepfrequencies.sudoku.domain.SudokuPlayground;
import org.junit.Assert;
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

	@Test
	public void testApplyStrategyDeprecated() throws Exception {
		ObviousSinglesStrategy testSubject;
		SudokuPlayground applyTo = new SudokuPlayground(Definitions.EMPTYPLAYGROUND);

		// default test
		testSubject = createTestSubject();
		testSubject.applyStrategy(applyTo);
	}
}