package org.deepfrequencies.sudoku.ui;

import java.util.Map;

import javax.annotation.Resource;

import org.deepfrequencies.sudoku.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
  loader=AnnotationConfigContextLoader.class,
  classes=Application.class)
public class SudokuResponseBuilderTest extends TestCase {
	
	private final String importSudoku = "300401076602500040000006210500000180700010002021000007054300000090004608830109004";

	@Resource(name="responseBuilder")	
	SudokuResponseBuilder responseBuilder; 
	private SudokuResponseBuilder createTestSubject() {
		return responseBuilder;
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