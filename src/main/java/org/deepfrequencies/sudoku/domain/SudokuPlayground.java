package org.deepfrequencies.sudoku.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This class represents a Sudoku playground as a simple matrix of 9 rows and 9 columns.
 * @author markus
 *
 */
public class SudokuPlayground implements Iterator<SudokuCell>{
	
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
			result = prime * result + getOuterType().hashCode();
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
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}


		private SudokuPlayground getOuterType() {
			return SudokuPlayground.this;
		}
	}
	
	private Map<Pair,SudokuCell> cellMap = new HashMap<>();

	public Collection<SudokuCell> getCells() {
		return cellMap.values();
	}

	public SudokuPlayground (String toLoad) {
		logger.info("SudokuPlayground entry");
		logger.info("SudokuPlayground - toLoad = {0}", toLoad);
		String[] lines = toLoad.split("(?<=\\G.{9})");
		//create cellMap with values
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				logger.info("SudokuPlayground: i = " + i + "j = " + j + ", value = " + lines[i-1].charAt(j-1));

				SudokuCell cell = new SudokuCell(Integer.valueOf(String.valueOf(lines[i-1].charAt(j-1))));
				cellMap.put(new Pair(i, j), cell);
			}
		}
		//set rows for every cell
		for (Map.Entry<Pair,SudokuCell> entry : cellMap.entrySet()) {
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
		
		//set column for every cell
		for (Pair key : cellMap.keySet()) {
			SudokuCell cell = cellMap.get(key);
			ArrayList<Integer> colValues = new ArrayList<>();
			for (int i = 1; i <= 9; i++) {
				SudokuCell belongsToCol = cellMap.get(new Pair(i, key.y));
				if (belongsToCol.getValue() > 0)
					colValues.add(belongsToCol.getValue()); 
			}
			cell.setColumn(colValues);
		}
		
		//set sector for every cell
		//for that, first determine all sectors
		Map<Pair,ArrayList<Integer>> sectorMap = new HashMap<>();
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				ArrayList<Integer> sector = new ArrayList<>();
				sectorMap.put(new Pair(i, j), sector);
			}
		}
		//now set values in sector, and put sector in cell
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				SudokuCell cell = cellMap.get(new Pair(i, j));
				int v = cell.getValue();
				ArrayList<Integer> sector = sectorMap.get(new Pair(i%3+1, j%3+1));
				if (v > 0) {
    				sector.add(v);
    			}
				cell.setSector(sector);
			}
		}
	}
	
	public SudokuCell getCell(int i, int j) {
		return cellMap.get(new Pair(i, j));
	}

	@Override
	public boolean hasNext() {
		return cellMap.keySet().iterator().hasNext();
	}

	@Override
	public SudokuCell next() {
		return cellMap.get(cellMap.keySet().iterator().next());
	}
}
