package org.deepfrequencies.sudoku.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SudokuCell {
	int value;
	List<Integer> options = new ArrayList<>();
	List<Integer> columnValues = new ArrayList<>();
	List<Integer> rowValues = new ArrayList<>();
	List<Integer> sectorValues = new ArrayList<>();
	
	List<SudokuCell> row = new ArrayList<>();
	List<SudokuCell> column = new ArrayList<>();
	List<SudokuCell> sector = new ArrayList<>();

	
	public SudokuCell (int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
		if (value > 0) {
			clearOptions();
		}
	}

	public List<Integer> getOptions() {
		return options;
	}
	
	public void clearOptions() {
		options.clear();
	}
	
	public void addOption(int option) {
		options.add(option);
		options.sort(Comparator.naturalOrder());
	}
	
	public void removeInvalidOptions() {
		row.forEach(cell -> cell.getOptions().remove(Integer.valueOf(value)));
		column.forEach(cell -> cell.getOptions().remove(Integer.valueOf(value)));
		sector.forEach(cell -> cell.getOptions().remove(Integer.valueOf(value)));
	}
	
	public List<Integer> getColumnValues() {
		return columnValues;
	}
	public void setColumnValues(List<Integer> columnValues) {
		this.columnValues = columnValues;
	}
	public List<Integer> getRowValues() {
		return rowValues;
	}
	public void setRowValues(List<Integer> rowValues) {
		this.rowValues = rowValues;
	}
	public List<Integer> getSectorValues() {
		return sectorValues;
	}
	public void setSectorValues(List<Integer> sectorValues) {
		this.sectorValues = sectorValues;
	}

	public List<SudokuCell> getRow() {
		return row;
	}

	public void setRow(List<SudokuCell> row) {
		this.row = row;
	}

	public List<SudokuCell> getColumn() {
		return column;
	}

	public void setColumn(List<SudokuCell> column) {
		this.column = column;
	}

	public List<SudokuCell> getSector() {
		return sector;
	}

	public void setSector(List<SudokuCell> sector) {
		this.sector = sector;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SudokuCell))
			return false;
		SudokuCell other = (SudokuCell) obj;
		if (value != other.value)
			return false;
		return true;
	}
}
