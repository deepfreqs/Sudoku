package org.deepfrequencies.sudoku.domain;

import java.util.Collection;

import org.deepfrequencies.sudoku.Definitions;
import org.junit.Test;

import junit.framework.TestCase;


public class SudokuPlaygroundTest extends TestCase {

	private SudokuPlayground createTestSubject() {
		return new SudokuPlayground("300401076602500040000006210500000180700010002021000007054300000090004608830109004");
	}

	@Test
	public void testGetCells() throws Exception {
		SudokuPlayground testSubject;
		Collection<SudokuCell> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getCells();
	}

	@Test
	public void testGetCell() throws Exception {
		SudokuPlayground testSubject;
		int i = 1;
		int j = 1;
		SudokuCell result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getCell(i, j);
		assertTrue(result != null);
	}

	@Test
	public void testToString() throws Exception {
		SudokuPlayground testSubject;
		int i = 1;
		int j = 1;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.toString();
		assertTrue(result != null);
	}

	@Test
	public void testEqualsAndClone() throws Exception {
		SudokuPlayground testSubject;
		int i = 1;
		int j = 1;
		String result;

		// default test
		testSubject = createTestSubject();
		SudokuPlayground other = testSubject.clone();
		assertTrue(testSubject.equals(other));
		other = new SudokuPlayground(Definitions.EMPTYPLAYGROUND);
		assertFalse(testSubject.equals(other));
		
	}
}