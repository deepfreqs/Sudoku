package org.deepfrequencies.sudoku.ui;

import java.util.HashMap;
import java.util.Map;

import org.deepfrequencies.sudoku.domain.SudokuCell;
import org.deepfrequencies.sudoku.domain.SudokuPlayground;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SudokuForm {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	Map<String,SudokuSquare> sqs = new HashMap<>();
	String importSudoku = "";
	String playThis = "";
	String strategy ="";
	
	public SudokuForm() {
    	for (int i = 1; i <= 3; i++) {
    		for (int j = 1; j <= 3; j++) {
    			SudokuSquare square = new SudokuSquare();
        		sqs.put(String.valueOf(i) + String.valueOf(j), square);
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
        		sqs.put(String.valueOf(i+1) + String.valueOf(j+1), square);
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

				sqs.put(String.valueOf(i+1) + String.valueOf(j+1), square);
				
			}
		}
	}

	public SudokuForm removeNullValues() {
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				String key = String.valueOf(i) + String.valueOf(j);
				SudokuSquare square = sqs.get(key);
				square.removeNullValues();
			}
		}
		return this;
	}


	public Map<String,SudokuSquare> getSqs() {
		return sqs;
	}

	public void setSqs(Map<String,SudokuSquare> sudokuSquares) {
		this.sqs = sudokuSquares;
	}

	public String getImportSudoku() {
		return importSudoku;
	}
	public void setImportSudoku(String importSudoku) {
		this.importSudoku = importSudoku;
	}
	
	public String getPlayThis() {
		return playThis;
	}

	public void setPlayThis(String playThis) {
		this.playThis = playThis;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public String exportToString() {
		if (! importSudoku.isEmpty())
			return importSudoku;
		StringBuilder toExport = new StringBuilder();
    	for (int i = 1; i <= 3; i++) {
    		SudokuSquare square1 = sqs.get(String.valueOf(i) + "1");
    		SudokuSquare square2 = sqs.get(String.valueOf(i) + "2");
    		SudokuSquare square3 = sqs.get(String.valueOf(i) + "3");
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
				SudokuSquare square = sqs.get(key);
				builder.append("--------" + key + "--------");
				builder.append("\n");
				builder.append(square.toString());
				builder.append("\n");
			}
		}
		builder.append("import: ").append(this.importSudoku).append("\nplayThis: ").append(this.playThis).append("\n");
		builder.append("strategy: ").append(this.strategy);
		return builder.toString(); 
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((importSudoku == null) ? 0 : importSudoku.hashCode());
		result = prime * result + ((sqs == null) ? 0 : sqs.hashCode());
		return result;
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
		if (sqs == null) {
			if (other.sqs != null)
				return false;
		} else {
			for (Map.Entry<String,SudokuSquare> entry : sqs.entrySet()) {
				String key = entry.getKey();
				if (!sqs.get(key).equals(other.sqs.get(key)))
					return false;
			}
		}
		return true;
	}


}
