package org.deepfrequencies.sudoku.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class SudokuCellTest extends TestCase{

	private SudokuCell createTestSubject() {
		return new SudokuCell(new Location(1,1),5);
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
		List<SudokuCell> result;
		// default test
		testSubject = createTestSubject();
		result = testSubject.getColumn();
		assertNotNull(result);
	}

	@Test
	public void testSetColumn() throws Exception {
		SudokuCell testSubject;
		List<SudokuCell> result = new ArrayList<>();
		// default test
		testSubject = createTestSubject();
		testSubject.setColumn(result);
		assertNotNull(testSubject.getColumn());
		assertNotNull(testSubject.getColumnValues());
	}

	@Test
	public void testGetRow() throws Exception {
		SudokuCell testSubject;
		List<SudokuCell> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getRow();
		assertNotNull(result);
	}

	@Test
	public void testSetRow() throws Exception {
		SudokuCell testSubject;
		List<SudokuCell> result = new ArrayList<>();

		// default test
		testSubject = createTestSubject();
		testSubject.setRow(result);
		assertNotNull(testSubject.getRow());
		assertNotNull(testSubject.getRowValues());
		assertNotNull(result);
	}

	@Test
	public void testGetSector() throws Exception {
		SudokuCell testSubject;
		List<SudokuCell> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getSector();
		assertNotNull(result);
	}

	@Test
	public void testSetSector() throws Exception {
		SudokuCell testSubject;
		List<SudokuCell> result = new ArrayList<>();

		// default test
		testSubject = createTestSubject();
		testSubject.setSector(result);
		assertNotNull(testSubject.getSector());
		assertNotNull(testSubject.getSectorValues());
		assertNotNull(result);
	}
}