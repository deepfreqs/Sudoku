package org.deepfrequencies.sudoku.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SudokuForm {
	
	Map<String,SudokuSquare> sudokuSquares = new HashMap<String,SudokuSquare>();
	Map<String,Object> sudokuOptions = new HashMap<String,Object>();

	public SudokuForm() {
    	for (int i = 1; i <= 3; i++) {
    		for (int j = 1; j <= 3; j++) {
    			SudokuSquare square = new SudokuSquare();
    			square.setA1(String.valueOf(i*j*1));
    			//square.setB1(String.valueOf(i*j*2));
    			square.addOption("B1", new String[] {"2", "4"});
    			square.setC1(String.valueOf(i*j*3));
    			square.setA2(String.valueOf(i*j*4));
    			square.setB2(String.valueOf(i*j*5));
    			square.setC2(String.valueOf(i*j*6));
    			square.setA3(String.valueOf(i*j*7));
    			square.setB3(String.valueOf(i*j*8));
    			square.setC3(String.valueOf(i*j*9));
        		sudokuSquares.put(String.valueOf(i) + String.valueOf(j), square);
    		}
    	} 
	}


	public Map<String,SudokuSquare> getSudokuSquares() {
		return sudokuSquares;
	}

	public void setSudokuSquares(Map<String,SudokuSquare> sudokuSquares) {
		this.sudokuSquares = sudokuSquares;
	}


	public Map<String, Object> getSudokuOptions() {
		return sudokuOptions;
	}


	public void setSudokuOptions(Map<String, Object> sudokuOptions) {
		this.sudokuOptions = sudokuOptions;
	}
}
