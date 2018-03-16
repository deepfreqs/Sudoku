package org.deepfrequencies.sudoku.ui;

import java.util.HashMap;
import java.util.Map;

public class SudokuForm {
	
	Map<String,SudokuSquare> sudokuSquares = new HashMap<String,SudokuSquare>();
	String importSudoku = new String();

	public SudokuForm() {
    	for (int i = 1; i <= 3; i++) {
    		for (int j = 1; j <= 3; j++) {
    			SudokuSquare square = new SudokuSquare();
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
