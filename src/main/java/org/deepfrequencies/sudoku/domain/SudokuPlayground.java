package org.deepfrequencies.sudoku.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
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

	public Collection<SudokuCell> getCells() {
		return cellMap.values();
	}

	public boolean isSolved() {
		SudokuCell zero = new SudokuCell(0);
		if (this.cellMap.containsValue(zero))
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
		// set rows for every cell
		for (Map.Entry<Pair, SudokuCell> entry : cellMap.entrySet()) {
			Pair key = entry.getKey();
			SudokuCell cell = entry.getValue();
			ArrayList<Integer> rowValues = new ArrayList<>();
			for (int i = 1; i <= 9; i++) {
				SudokuCell belongsToRow = cellMap.get(new Pair(key.x, i));
				if (belongsToRow.getValue() > 0)
					rowValues.add(belongsToRow.getValue());
			}
			cell.setRow(rowValues);
		}

		// set column for every cell
		for (Map.Entry<Pair, SudokuCell> entry : cellMap.entrySet()) {
			Pair key = entry.getKey();
			SudokuCell cell = entry.getValue();
			ArrayList<Integer> colValues = new ArrayList<>();
			for (int i = 1; i <= 9; i++) {
				SudokuCell belongsToCol = cellMap.get(new Pair(i, key.y));
				if (belongsToCol.getValue() > 0)
					colValues.add(belongsToCol.getValue());
			}
			cell.setColumn(colValues);
		}

		// set sector for every cell
		// for that, first determine all sectors
		Map<Pair, ArrayList<Integer>> sectorMap = new HashMap<>();
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				ArrayList<Integer> sector = new ArrayList<>();
				sectorMap.put(new Pair(i, j), sector);
			}
		}
		// now set values in sector, and put sector in cell
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				SudokuCell cell = cellMap.get(new Pair(i, j));
				int v = cell.getValue();
				int iIndex = ((i - 1) / 3) + 1;
				int jIndex = ((j - 1) / 3) + 1;
				ArrayList<Integer> sector = sectorMap.get(new Pair(iIndex, jIndex));
				if (v > 0) {
					sector.add(v);
				}
				cell.setSector(sector);
			}
		}

		if (logger.isDebugEnabled()) {
			for (int i = 1; i <= 9; i++) {
				for (int j = 1; j <= 9; j++) {
					SudokuCell cell = cellMap.get(new Pair(i, j));
					logger.debug(
							"SudokuPlayground: current key: i = " + i + ", j = " + j + ", value = " + cell.getValue());
					logger.debug("SudokuPlayground: row values for current cell: i = " + i + ", j = " + j
							+ ", values = " + cell.getRow().toString());
					logger.debug("SudokuPlayground: col values for current cell: i = " + i + ", j = " + j
							+ ", values = " + cell.getColumn().toString());
					logger.debug("SudokuPlayground: sector values for current cell: i = " + i + ", j = " + j
							+ ", values = " + cell.getSector().toString());
				}
			}
		}

	}

	public SudokuCell getCell(int i, int j) {
		return cellMap.get(new Pair(i, j));
	}

	@Override
	public int hashCode() {
		int[] vlist = cellMap.values().stream().mapToInt(c -> Integer.valueOf(c.getValue())).toArray();
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) ((cellMap == null) ? 0 : Arrays.stream(vlist).reduce((a, b) -> a + b));
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
		} else
			if (! new ArrayList<>(cellMap.entrySet()).equals(new ArrayList<>(other.cellMap.entrySet())))
				return false;
			return true;
	}

	public SudokuPlayground clone() {
		try {
			return (SudokuPlayground) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				builder.append("\n").append(this.getCell(i,j).getValue());
			}
		}
		return builder.toString();
	}
}
