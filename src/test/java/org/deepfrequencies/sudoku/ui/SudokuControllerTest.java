package org.deepfrequencies.sudoku.ui;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.deepfrequencies.sudoku.Application;
import org.deepfrequencies.sudoku.Definitions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import junit.framework.TestCase;


/**
 * Just wanted to explore Mockito as a mocking framework.
 * Works, but strange is that the mockito tests dont contribute anything 
 * to the coverage.
 * @author deepfrequencies
 *
 */
@ActiveProfiles("testtest")
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = SudokuController.class, secure = false)
@ContextConfiguration(classes = {Application.class})
public class SudokuControllerTest extends TestCase {
	@Autowired	
	private MockMvc mockMvc;

	@MockBean	
	SudokuResponseBuilder mockedResponseBuilder;

	@Test
	public void testGetRequest() throws Exception {
		when(mockedResponseBuilder.newSudokuForm()).thenReturn(new SudokuForm(Definitions.EMPTYPLAYGROUND));
		mockMvc.perform(get("/sudoku")).andExpect(status().is2xxSuccessful()).andExpect(MockMvcResultMatchers.view().name("sudoku"));
		verify(mockedResponseBuilder, Mockito.times(1)).newSudokuForm();
	}
	
}
