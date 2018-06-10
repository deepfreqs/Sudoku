package org.deepfrequencies.sudoku.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SudokuCell {
	int value;
	List<Integer> options = new ArrayList<>();
	List<Integer> column;
	List<Integer> row;
	List<Integer> sector;
	
	SudokuCell (int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public List<Integer> getOptions() {
		return options;
	}
	
	public void addOption(int option) {
		options.add(option);
		options.sort(Comparator.naturalOrder());
	}
	public List<Integer> getColumn() {
		return column;
	}
	public void setColumn(List<Integer> column) {
		this.column = column;
	}
	public List<Integer> getRow() {
		return row;
	}
	public void setRow(List<Integer> row) {
		this.row = row;
	}
	public List<Integer> getSector() {
		return sector;
	}
	public void setSector(List<Integer> sector) {
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
