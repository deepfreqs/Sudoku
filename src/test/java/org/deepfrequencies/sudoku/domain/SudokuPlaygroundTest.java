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
		assertTrue(result.size() != 0);
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
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.toString();
		assertTrue(result != null);
	}

	@Test
	public void testEqualsAndClone() throws Exception {
		SudokuPlayground testSubject;
		// default test
		testSubject = createTestSubject();
		SudokuPlayground other = testSubject.copy();
		assertTrue(testSubject.equals(other));
		other = new SudokuPlayground(Definitions.EMPTYPLAYGROUND);
		assertFalse(testSubject.equals(other));
		
	}

	@Test
	public void testIsSolved() throws Exception {
		SudokuPlayground testSubject;
		// default test
		testSubject = createTestSubject();
		assertFalse(testSubject.isSolved());
	}
	
	@Test
	public void testSetHiddenSinglesAsValues() throws Exception {
		SudokuPlayground testSubject;
		// default test
		testSubject = createTestSubject();
		testSubject.calculateOptions();
		System.out.println(testSubject.toString());
		testSubject.setHiddenSinglesAsValues();
		assertFalse(testSubject.isSolved());
	}

}