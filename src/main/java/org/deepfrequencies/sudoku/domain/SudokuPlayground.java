package org.deepfrequencies.sudoku.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

	private Map<Location, SudokuCell> cellMap = new LinkedHashMap<>();
	private Map<Location, Map<Location, SudokuCell>> sectorMap = new LinkedHashMap<>();

	public Collection<SudokuCell> getCells() {
		return cellMap.values();
	}

	public boolean isSolved() {
		return getCells().stream().filter(cell -> cell.getValue() == 0).collect(Collectors.counting()) == 0 ? true : false;
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
				SudokuCell cell = new SudokuCell(new Location(i, j),
						Integer.parseInt(String.valueOf(lines[i - 1].substring(j - 1, j))));
				cellMap.put(new Location(i, j), cell);
			}
		}
		initPlayground();
		initCells();
	}

	private void initPlayground() {
		// init Map of Sector (containing Maps of cells)
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				Map<Location, SudokuCell> sector = new HashMap<>();
				sectorMap.put(new Location(i, j), sector);
			}
		}
		// and add the cells to the sectors, as part of the inner sector map
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				int iIndex = ((i - 1) / 3) + 1;
				int jIndex = ((j - 1) / 3) + 1;
				sectorMap.get(new Location(iIndex, jIndex)).put(new Location(i, j), this.getCell(i, j));
			}
		}
	}

	private void initCells() {
		for (Map.Entry<Location, SudokuCell> e : cellMap.entrySet()) {
			// set the cells in the column / row WITHOUT self
			e.getValue().setColumn(cellMap.keySet().stream().filter(p -> !p.equals(e.getKey()) && p.j == e.getKey().j)
					.map(cellMap::get).collect(Collectors.toList()));
			e.getValue().setRow(cellMap.keySet().stream().filter(p -> !p.equals(e.getKey()) && p.i == e.getKey().i)
					.map(k -> cellMap.get(k)).collect(Collectors.toList()));
			// set ALL values excluding zeros
			e.getValue().setColumnValues(
					cellMap.keySet().stream().filter(p -> p.j == e.getKey().j && cellMap.get(p).getValue() != 0)
							.map(k -> cellMap.get(k).getValue()).collect(Collectors.toList()));
			e.getValue().setRowValues(
					cellMap.keySet().stream().filter(p -> p.i == e.getKey().i && cellMap.get(p).getValue() != 0)
							.map(k -> cellMap.get(k).getValue()).collect(Collectors.toList()));
			// put the cells of the sector in the cell WITHOUT self
			e.getValue()
					.setSector(sectorMap.get(new Location((e.getKey().i - 1) / 3 + 1, (e.getKey().j - 1) / 3 + 1))
							.entrySet().stream().filter(ee -> ee.getKey() != e.getKey()).map(eee -> eee.getValue())
							.collect(Collectors.toList()));
			// put the cells of the sector in the cell WITHOUT self
			e.getValue()
					.setSectorValues(sectorMap.get(new Location((e.getKey().i - 1) / 3 + 1, (e.getKey().j - 1) / 3 + 1))
							.entrySet().stream()
							.filter(ee -> ee.getKey() != e.getKey() && ee.getValue().getValue() != 0)
							.map(eee -> eee.getValue()).map(c -> c.getValue()).collect(Collectors.toList()));
		}
	}

	public SudokuCell getCell(int i, int j) {
		return cellMap.get(new Location(i, j));
	}

	public void removeInvalidOptions() {
		getCells().forEach(SudokuCell::removeInvalidOptions);
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
		getCells().forEach(SudokuCell::calculateOptions);
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
		getCells().forEach(SudokuCell::clearOptions);
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
		getCells().forEach(SudokuCell::setSingleOptionAsValues);
	}

	public void setHiddenSinglesAsValues() {
		getCells().forEach(SudokuCell::setHiddenSinglesAsValues);
	}

}
