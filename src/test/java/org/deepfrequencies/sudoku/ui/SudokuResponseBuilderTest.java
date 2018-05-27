package org.deepfrequencies.sudoku.ui;

import java.util.Map;

import org.junit.Test;

import junit.framework.TestCase;

public class SudokuResponseBuilderTest extends TestCase {
	
	private final String importSudoku = "300401076602500040000006210500000180700010002021000007054300000090004608830109004";

	private SudokuResponseBuilder createTestSubject() {
		return SudokuResponseBuilder.getBuilder();
	}

	@Test
	public void testGetBuilder() throws Exception {
		SudokuResponseBuilder result;

		// default test
		result = SudokuResponseBuilder.getBuilder();
		assertNotNull(result);
	}

	@Test
	public void testNewSudokuForm() throws Exception {
		SudokuResponseBuilder testSubject;
		SudokuForm result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.newSudokuForm();
		assertNotNull(result);
	}

	@Test
	public void testCalculateNextStep() throws Exception {
		SudokuResponseBuilder testSubject = createTestSubject();
		SudokuForm sudokuForm = new SudokuForm(importSudoku);
		SudokuForm result = testSubject.takeAStep(sudokuForm);
		assertTrue(result.equals(sudokuForm));
	}

	@Test
	public void testRemoveNullValues() throws Exception {
		SudokuResponseBuilder testSubject;
		SudokuForm sudokuForm = new SudokuForm(importSudoku);
		SudokuForm result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.removeNullValues(sudokuForm);
		assertNotNull(result);
	}

	@Test
	public void testLoadFromString() throws Exception {
		SudokuResponseBuilder testSubject;
		String toLoad = importSudoku;
		SudokuForm result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.loadFromString(toLoad);
		assertNotNull(result);
	}

}