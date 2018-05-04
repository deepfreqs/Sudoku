package org.deepfrequencies.sudoku.ui;

import java.util.HashMap;
import java.util.Map;

import org.deepfrequencies.sudoku.domain.SudokuCell;
import org.deepfrequencies.sudoku.domain.SudokuPlayground;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SudokuForm {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	Map<String,SudokuSquare> sudokuSquares = new HashMap<>();
	String importSudoku = "";
	
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
		if (lines.length != 9) {
			logger.info("not a valid Sudoku input");
		}
		this.setImportSudoku(toLoad);
		String pattern = "(?<=\\G.{3})";
    	for (int i = 0; i < 3; i++) {
    		String[] squareLines1 = lines[i*3].split(pattern);
    		String[] squareLines2 = lines[i*3 + 1].split(pattern);
    		String[] squareLines3 = lines[i*3 + 2].split(pattern);
    		for (int j = 0; j < 3; j++) {
    			SudokuSquare square = new SudokuSquare(squareLines1[j], squareLines2[j], squareLines3[j]);
        		sudokuSquares.put(String.valueOf(i+1) + String.valueOf(j+1), square);
    		}
    	} 
	}
	
	public SudokuForm (SudokuPlayground ground) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				SudokuSquare square = new SudokuSquare();
				//here i need something to get the options out of the cells
				SudokuCell cell = ground.getCell(i*3+1, j*3+1);
				square.setA1(String.valueOf(cell.getValue()));
				square.setA1Options(cell.getOptions());
				cell = ground.getCell(i*3+1, j*3+2);
				square.setB1(String.valueOf(cell.getValue()));
				square.setB1Options(cell.getOptions());
				cell = ground.getCell(i*3+1, j*3+3);
				square.setC1(String.valueOf(cell.getValue()));
				square.setC1Options(cell.getOptions());

				cell = ground.getCell(i*3+2, j*3+1);
				square.setA2(String.valueOf(cell.getValue()));
				square.setA2Options(cell.getOptions());
				cell = ground.getCell(i*3+2, j*3+2);
				square.setB2(String.valueOf(cell.getValue()));
				square.setB2Options(cell.getOptions());
				cell = ground.getCell(i*3+2, j*3+3);
				square.setC2(String.valueOf(cell.getValue()));
				square.setC2Options(cell.getOptions());

				cell = ground.getCell(i*3+3, j*3+1);
				square.setA3(String.valueOf(cell.getValue()));
				square.setA3Options(cell.getOptions());
				cell = ground.getCell(i*3+3, j*3+2);
				square.setB3(String.valueOf(cell.getValue()));
				square.setB3Options(cell.getOptions());
				cell = ground.getCell(i*3+3, j*3+3);
				square.setC3(String.valueOf(cell.getValue()));
				square.setC3Options(cell.getOptions());

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
	
	public String exportToString() {
		if (! importSudoku.isEmpty())
			return importSudoku;
		StringBuilder toExport = new StringBuilder();
    	for (int i = 1; i <= 3; i++) {
    		SudokuSquare square1 = sudokuSquares.get(String.valueOf(i) + "1");
    		SudokuSquare square2 = sudokuSquares.get(String.valueOf(i) + "2");
    		SudokuSquare square3 = sudokuSquares.get(String.valueOf(i) + "3");
    		for (int j = 1; j <= 3; j++) {
    			String line1 = square1.getRowForExport(j);
    			String line2 = square2.getRowForExport(j);
    			String line3 = square3.getRowForExport(j);
           		toExport.append(line1).append(line2).append(line3);
    		}
    	} 
		return toExport.toString();
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SudokuForm other = (SudokuForm) obj;
		if (sudokuSquares == null) {
			if (other.sudokuSquares != null)
				return false;
		} else {
			for (String key : sudokuSquares.keySet()) {
				if (!sudokuSquares.get(key).equals(other.sudokuSquares.get(key)))
					return false;
			}
		}
		return true;
	}


}
