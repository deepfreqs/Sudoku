package org.deepfrequencies.sudoku.ui;

import java.util.HashMap;
import java.util.Map;

public class SudokuForm {
	
	Map<String,SudokuSquare> sudokuSquares = new HashMap<String,SudokuSquare>();
	Map<String,Object> sudokuOptions = new HashMap<String,Object>();
	String importSudoku = new String();

	public SudokuForm() {
    	for (int i = 1; i <= 3; i++) {
    		for (int j = 1; j <= 3; j++) {
    			SudokuSquare square = new SudokuSquare();
    			square.setA1(String.valueOf(i*j*1));
    			square.addOption("A1", new String[] {" ", "1", "3", "4", "5", "7", "8", "9"});
    			//square.setB1(String.valueOf(i*j*2));
    			square.addOption("B1", new String[] {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9"});
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
	
	public SudokuForm(String toLoad) {
		String[] lines = toLoad.split("(?<=\\G.{9})");
		if (lines.length < 9) {
			System.out.println("not a valid Sudoku input");
		}
    	for (int i = 0; i < 3; i++) {
    		String[] squareLines1 = lines[i*3].split("(?<=\\G.{3})");
    		String[] squareLines2 = lines[i*3 + 1].split("(?<=\\G.{3})");
    		String[] squareLines3 = lines[i*3 + 2].split("(?<=\\G.{3})");
    		for (int j = 0; j < 3; j++) {
    			SudokuSquare square = new SudokuSquare(squareLines1[j], squareLines2[j], squareLines3[j]);
        		sudokuSquares.put(String.valueOf(i+1) + String.valueOf(j+1), square);
    		}
    	} 
	}

	public SudokuForm removeNullValues() {
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				String key = String.valueOf(i) + String.valueOf(j);
				SudokuSquare square = sudokuSquares.get(key);
				square.removeNullValues();
			}
		}
		return this;
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
	public String getImportSudoku() {
		return importSudoku;
	}
	public void setImportSudoku(String importSudoku) {
		this.importSudoku = importSudoku;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				String key = String.valueOf(i) + String.valueOf(j);
				SudokuSquare square = sudokuSquares.get(key);
				builder.append("--------" + key + "--------");
				builder.append("\n");
				builder.append(square.toString());
				builder.append("\n");
			}
		}
		return builder.toString(); 
		
	}


}
