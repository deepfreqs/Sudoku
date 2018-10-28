package org.deepfrequencies.sudoku.ui;

import java.util.Map;

import org.junit.Test;

import junit.framework.TestCase;

public class SudokuFormTest extends TestCase{
	
	String importSudoku = "300401076602500040000006210500000180700010002021000007054300000090004608830109004";

	private SudokuForm createTestSubject() {
		return new SudokuForm(importSudoku);
	}

	@Test
	public void testRemoveNullValues() throws Exception {
		SudokuForm testSubject;
		SudokuForm result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.removeNullValues();
		assertNotNull(result);
	}

	@Test
	public void testGetSudokuSquares() throws Exception {
		SudokuForm testSubject;
		Map<String, SudokuSquare> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getSqs();
		assertNotNull(result);
	}

	@Test
	public void testSetSudokuSquares() throws Exception {
		SudokuForm testSubject;
		Map<String, SudokuSquare> sudokuSquares = null;

		// default test
		testSubject = createTestSubject();
		testSubject.setSqs(sudokuSquares);
	}

	@Test
	public void testGetImportSudoku() throws Exception {
		SudokuForm testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getImportSudoku();
		assertNotNull(result);
	}

	@Test
	public void testSetImportSudoku() throws Exception {
		SudokuForm testSubject;
		String importSudoku = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setImportSudoku(importSudoku);
	}

	@Test
	public void testExportToString() throws Exception {
		SudokuForm testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.exportToString();
		assertTrue(result.equals(testSubject.getImportSudoku()));
		//now not just the string return
		testSubject.setImportSudoku("");
		result = testSubject.exportToString();
		assertTrue(result.equals(importSudoku));
	}
}