package org.deepfrequencies.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.deepfrequencies.sudoku.domain.SudokuCell;

public class Definitions {
	public static final String EMPTYPLAYGROUND = "000000000000000000000000000000000000000000000000000000000000000000000000000000000";
	public static final SudokuCell zero = new SudokuCell(0);
	public static final List<Integer> allValues = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

	
	private Definitions () {
		
	}
}
