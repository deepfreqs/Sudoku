package org.deepfrequencies.sudoku.ui;

import java.util.HashMap;
import java.util.Map;

public class SudokuForm {
	
	Map<String,Object> sudokuRows = new HashMap<String,Object>();

	public Map<String, Object> getSudokuRows() {
		return sudokuRows;
	}

	public void setSudokuRows(Map<String, Object> sudokuRows) {
		this.sudokuRows = sudokuRows;
	}

	public SudokuForm() {
    	Map<String,Object> sudokuCols = new HashMap<String,Object>();
    	
    	HashMap<String,Object> sudokuCells = new HashMap<String,Object>();
    	for (int i = 1; i <= 3; i++) {
    		for (int j = 1; j <= 3; j++) {
    			SudokuSquare square = new SudokuSquare();
    			square.setA1(String.valueOf(i*j*1));
    			square.setB1(String.valueOf(i*j*2));
    			square.setC1(String.valueOf(i*j*3));
    			square.setA2(String.valueOf(i*j*4));
    			square.setB2(String.valueOf(i*j*5));
    			square.setC2(String.valueOf(i*j*6));
    			square.setA3(String.valueOf(i*j*7));
    			square.setB3(String.valueOf(i*j*8));
    			square.setC3(String.valueOf(i*j*9));
    			sudokuCells.put(String.join("", String.valueOf(i), String.valueOf(j)), square);
        		sudokuCols.put(String.valueOf(j),square);
    		}
    		sudokuRows.put(String.valueOf(i), sudokuCols);
    	} 
	}
}
