package org.deepfrequencies.sudoku.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.deepfrequencies.sudoku.Definitions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represents a Sudoku playground as a simple matrix of 9 rows and 9
 * columns.
 * 
 * @author markus
 *
 */
public class SudokuPlayground implements Cloneable {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private class Pair {
		public int x;
		public int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
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
			Pair other = (Pair) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}

	private Map<Pair, SudokuCell> cellMap = new LinkedHashMap<>();
	private Map<Integer, List<SudokuCell>> rows = new HashMap<>();
	private Map<Integer, List<SudokuCell>> columns = new HashMap<>();
	private Map<Pair, List<SudokuCell>> sectors = new LinkedHashMap<>();
	private Map<Pair, Map<Pair, SudokuCell>> sectorMap = new LinkedHashMap<>();

	public Collection<SudokuCell> getCells() {
		return cellMap.values();
	}

	public boolean isSolved() {
		if (this.cellMap.containsValue(Definitions.zero))
			return false;
		return true;
	}

	public SudokuPlayground(String toLoad) {
		logger.info("SudokuPlayground entry");
		logger.info("SudokuPlayground - toLoad = {0}", toLoad);
		String[] lines = toLoad.split("(?<=\\G.{9})");
		// create cellMap with values
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (logger.isDebugEnabled()) {
					logger.debug(
							"SudokuPlayground: i = " + i + ", j = " + j + ", value = " + lines[i - 1].charAt(j - 1));
				}
				SudokuCell cell = new SudokuCell(Integer.parseInt(String.valueOf(lines[i - 1].substring(j - 1, j))));
				cellMap.put(new Pair(i, j), cell);
			}
		}
		initPlayground();
		initCells();
	}

	private void initPlayground() {
		//init Map of Sector (containing Maps of cells)
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				Map<Pair, SudokuCell> sector = new HashMap<>();
				sectorMap.put(new Pair(i, j), sector);
			}
		}
		// and add the cells to the sectors, as part of the inner sector map
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				int iIndex = ((i - 1) / 3) + 1;
				int jIndex = ((j - 1) / 3) + 1;
				sectorMap.get(new Pair(iIndex, jIndex)).put(new Pair(i, j), this.getCell(i, j));
			}
		}
	}

	private void initCells() {
		for (Map.Entry<Pair, SudokuCell> e : cellMap.entrySet()) {
			// set the cells in the column / row WITHOUT self
			e.getValue().setColumn(cellMap.keySet().stream().filter(p -> !p.equals(e.getKey()) && p.y == e.getKey().y)
					.map(k -> cellMap.get(k)).collect(Collectors.toList()));
			e.getValue().setRow(cellMap.keySet().stream().filter(p -> !p.equals(e.getKey()) && p.x == e.getKey().x)
					.map(k -> cellMap.get(k)).collect(Collectors.toList()));
			// set ALL values excluding zeros
			e.getValue().setColumnValues(
					cellMap.keySet().stream().filter(p -> p.y == e.getKey().y && cellMap.get(p).getValue() != 0)
							.map(k -> cellMap.get(k).getValue()).collect(Collectors.toList()));
			e.getValue().setRowValues(
					cellMap.keySet().stream().filter(p -> p.x == e.getKey().x && cellMap.get(p).getValue() != 0)
							.map(k -> cellMap.get(k).getValue()).collect(Collectors.toList()));
			// put the cells of the sector in the cell WITHOUT self
			e.getValue()
					.setSector(sectorMap.get(new Pair((e.getKey().x-1) / 3 + 1, (e.getKey().y-1) / 3 + 1)).entrySet().stream()
							.filter(ee -> ee.getKey() != e.getKey()).map(eee -> eee.getValue())
							.collect(Collectors.toList()));
			// put the cells of the sector in the cell WITHOUT self
			e.getValue()
					.setSectorValues(sectorMap.get(new Pair((e.getKey().x-1) / 3 + 1, (e.getKey().y-1) / 3 + 1)).entrySet().stream()
							.filter(ee -> ee.getKey() != e.getKey()).map(eee -> eee.getValue()).map(c -> c.getValue())
							.collect(Collectors.toList()));
		}
	}


	public SudokuCell getCell(int i, int j) {
		return cellMap.get(new Pair(i, j));
	}

	public Collection<SudokuCell> getRow(int i) {
		return rows.get(i);
	}

	public Collection<SudokuCell> getColumn(int i) {
		return columns.get(i);
	}

	public Collection<SudokuCell> getSector(int i, int j) {
		return sectors.get(new Pair(i, j));
	}

	public void removeInvalidOptions() {
		getCells().forEach(cell -> cell.removeInvalidOptions());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + toString().hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SudokuPlayground))
			return false;
		SudokuPlayground other = (SudokuPlayground) obj;
		if (cellMap == null) {
			if (other.cellMap != null)
				return false;
		} else if (!toString().equals(other.toString()))
			return false;
		return true;
	}

	public SudokuPlayground copy() {
		return new SudokuPlayground(this.toString().replaceAll("\n", ""));
	}

	public void calculateOptions() {
		Collection<SudokuCell> cells = this.getCells();
		for (SudokuCell cell : (Collection<SudokuCell>) cells) {
			// options only exist if cell is 0
			for (int i = 1; i <= 9; i++) {
				if (cell.getValue() == 0 && !cell.getRowValues().contains(i) && !cell.getColumnValues().contains(i)
						&& !cell.getSectorValues().contains(i)) {
					cell.addOption(i);
				}
			}
		}
		// this is only for checking plausibility
		if (logger.isDebugEnabled()) {
			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= 9; j++) {
					SudokuCell cell = this.getCell(i, j);
					if (cell.getValue() != 0 && cell.getOptions().contains(cell.getValue()))
						logger.debug("cell " + i + ", " + j + " has its value as option");
				}
			}
		}
	}

	public SudokuPlayground clearOptions() {
		getCells().forEach(c -> c.clearOptions());
		return this;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder("\n");
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				builder.append(this.getCell(i, j).getValue());
			}
			builder.append("\n");
		}
		return builder.toString();
	}

	public void setSingleOptionsAsValues() {
		for (SudokuCell cell : getCells()) {
			if (cell.getOptions().size() == 1) {
				cell.setValue(cell.getOptions().get(0));
			}
		}

		// getCells().forEach(cell -> cell.getOptions());

	}

	/*
	 * count occurences of a number in an aggregation of all values from row,
	 * column, sector of a cell if a number occurs only once, it is a hidden single
	 */
	public void setHiddenSinglesAsValues() {
		for (SudokuCell cell : getCells().stream().filter(cell -> cell.getValue() == 0).collect(Collectors.toList())) {
			List<Integer> options = new ArrayList<>();
			cell.getColumn().stream().filter(colCell -> colCell.getValue() == 0).map(SudokuCell::getOptions)
					.forEach(o -> options.addAll(o));
			cell.getRow().stream().filter(rowCell -> rowCell.getValue() == 0).map(SudokuCell::getOptions)
					.forEach(o -> options.addAll(o));
			cell.getSector().stream().filter(secCell -> secCell.getValue() == 0).map(SudokuCell::getOptions)
					.forEach(o -> options.addAll(o));
			Map<Integer, Long> m = options.stream()
					.collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
			logger.debug("SudokuPlayground: setHiddenSinglesAsValues: map of aggregation " + m.toString());
			// List<Integer> li = Definitions.allValues.stream().filter(i ->
			// !m.keySet().contains(i)).collect(Collectors.toList());
			List<Integer> li = m.entrySet().stream().filter(e -> e.getValue() == 1).map(Entry::getKey)
					.collect(Collectors.toList());
			logger.debug("SudokuPlayground: setHiddenSinglesAsValues: list of open values" + li.toString());
			if (li.size() == 1 && cell.getOptions().contains(li.get(0))) {
				Integer newValue = li.get(0);
				int oldValue = cell.getValue();
				logger.debug(
						"SudokuPlayground: setHiddenSinglesAsValues: old = " + oldValue + ", newValue = " + newValue);

				cell.setValue(li.get(0));
			}
			logger.debug("SudokuPlayground: " + this.toString());
		}
	}
}
