package org.deepfrequencies.sudoku.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SudokuCell {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	int value;
	Location location;
	List<Integer> options = new ArrayList<>();
	List<Integer> columnValues = new ArrayList<>();
	List<Integer> rowValues = new ArrayList<>();
	List<Integer> sectorValues = new ArrayList<>();

	List<SudokuCell> row = new ArrayList<>();
	List<SudokuCell> column = new ArrayList<>();
	List<SudokuCell> sector = new ArrayList<>();

	public SudokuCell(Location location, int value) {
		this.value = value;
		this.location = location;
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

	public void calculateOptions() {
		// options only exist if cell is 0
		for (int i = 1; i <= 9; i++) {
			if (getValue() == 0 && !getRowValues().contains(i) && !getColumnValues().contains(i)
					&& !getSectorValues().contains(i)) {
				addOption(i);
			}
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

	public void setSingleOptionAsValues() {
		if (getOptions().size() == 1) {
			setValue(getOptions().get(0));
		}
	}

	/*
	 * count occurences of a number in an aggregation of all values from row,
	 * column, sector of a cell if a number occurs only once, it is a hidden single
	 */
	public void setHiddenSinglesAsValues() {
		if (getValue() != 0)
			return;
		clearOptions();
		calculateOptions();
		setSingleOptionAsValues();
		List<Integer> o = new ArrayList<>();
		getColumn().stream().filter(colCell -> colCell.getValue() == 0).map(SudokuCell::getOptions)
				.forEach(o::addAll);
		getRow().stream().filter(rowCell -> rowCell.getValue() == 0).map(SudokuCell::getOptions)
				.forEach(o::addAll);
		getSector().stream().filter(secCell -> secCell.getValue() == 0).map(SudokuCell::getOptions)
				.forEach(o::addAll);
		Map<Integer, Long> m = o.stream()
				.collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
		logger.debug("SudokuPlayground: setHiddenSinglesAsValues: map of aggregation " + m.toString());
		List<Integer> li = m.entrySet().stream().filter(e -> e.getValue() == 1).map(Entry::getKey)
				.collect(Collectors.toList());
		logger.debug("SudokuPlayground: setHiddenSinglesAsValues: list of open values" + li.toString());
		if (li.size() == 1 && getOptions().contains(li.get(0))) {
			Integer newValue = li.get(0);
			int oldValue = getValue();
			logger.debug("SudokuPlayground: setHiddenSinglesAsValues: old = " + oldValue + ", newValue = " + newValue);

			setValue(li.get(0));
			this.getUniquedNeighbourhood().forEach(SudokuCell::setHiddenSinglesAsValues);
		}
		logger.debug("SudokuPlayground: " + this.toString());
	}

	private Collection<SudokuCell> getUniquedNeighbourhood() {
		Map<SudokuCell, Integer> uniquedNeighbourhood = new HashMap<>();
		getColumn().forEach(cell -> uniquedNeighbourhood.put(cell, cell.getValue()));
		getRow().forEach(cell -> uniquedNeighbourhood.put(cell, cell.getValue()));
		getSector().forEach(cell -> uniquedNeighbourhood.put(cell, cell.getValue()));
		return uniquedNeighbourhood.keySet();
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

	public String toString() {
		return "i: " + location.i + ", j: " + location.j + "value: " + Integer.toString(getValue());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + location.hashCode();
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
		return !location.equals(other.location) ? false : true;
	}
}
