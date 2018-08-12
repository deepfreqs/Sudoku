package org.deepfrequencies.sudoku.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class SudokuCellTest extends TestCase{

	private SudokuCell createTestSubject() {
		return new SudokuCell(5);
	}

	@Test
	public void testGetValue() throws Exception {
		SudokuCell testSubject;
		int result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getValue();
		assertTrue(result >= 0 && result < 10);
	}

	@Test
	public void testSetValue() throws Exception {
		SudokuCell testSubject;
		int value = 0;

		// default test
		testSubject = createTestSubject();
		testSubject.setValue(value);
		assertEquals(testSubject.getValue(), value);
	}

	@Test
	public void testGetOptions() throws Exception {
		SudokuCell testSubject;
		List<Integer> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getOptions();
		assertNotNull(result);
	}

	@Test
	public void testAddOption() throws Exception {
		SudokuCell testSubject;
		int option = 5;

		// default test
		testSubject = createTestSubject();
		testSubject.addOption(option);
		assertTrue(testSubject.getOptions().contains(option));
	}

	@Test
	public void testGetColumn() throws Exception {
		SudokuCell testSubject;
		List<Integer> result;
		// default test
		testSubject = createTestSubject();
		result = testSubject.getColumnValues();
		assertNotNull(result);
	}

	@Test
	public void testSetColumn() throws Exception {
		SudokuCell testSubject;
		List<Integer> result = new ArrayList<>();
		// default test
		testSubject = createTestSubject();
		testSubject.setColumnValues(result);
		result = testSubject.getColumnValues();
		assertNotNull(result);
	}

	@Test
	public void testGetRow() throws Exception {
		SudokuCell testSubject;
		List<Integer> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getRowValues();
		assertNotNull(result);
	}

	@Test
	public void testSetRow() throws Exception {
		SudokuCell testSubject;
		List<Integer> result = new ArrayList<>();

		// default test
		testSubject = createTestSubject();
		testSubject.setRowValues(result);
		result = testSubject.getRowValues();
		assertNotNull(result);
	}

	@Test
	public void testGetSector() throws Exception {
		SudokuCell testSubject;
		List<Integer> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getSectorValues();
		assertNotNull(result);
	}

	@Test
	public void testSetSector() throws Exception {
		SudokuCell testSubject;
		List<Integer> result = new ArrayList<>();

		// default test
		testSubject = createTestSubject();
		testSubject.setSectorValues(result);
		result = testSubject.getSectorValues();
		assertNotNull(result);
	}
}