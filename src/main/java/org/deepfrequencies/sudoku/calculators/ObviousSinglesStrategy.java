package org.deepfrequencies.sudoku.calculators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.deepfrequencies.sudoku.domain.SudokuCell;
import org.deepfrequencies.sudoku.domain.SudokuPlayground;

/**
 * If there is one option in a cell in a row / column / sector which cant be found in 
 * another cell in a row / column / sector then its a hit.
 * @author markus
 */
public class ObviousSinglesStrategy extends AbstractStrategy {
	
	/**
	 * For every cell for every option check if the touched row / column / sector 
	 * contains this option only once: then its a single.
	 * And then the other options of this cell in this row / column / sector can be deleted.
	 * So its an algorithms which works on row / column / sector.
	 * 
	 * @param applyTo The playground on which the strategy is applied.
	 */
	@Override
	public void applyStrategy(SudokuPlayground applyTo) {
		for(List<SudokuCell> row : applyTo.getRows().values()) {
			List<Integer> options = new ArrayList<Integer>();
			for(SudokuCell cell : row) {
				options.addAll(cell.getOptions());
			}
			Map<Integer, Long> counters = options.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
			for (Map.Entry<Integer, Long> entry : counters.entrySet()) {
				Integer key = entry.getKey();
				if (entry.getValue() == 1) {
					changeOptionsForContainerAndValue(row, key);
				}
			}
		}
		und das jetzt noch für Spalten und Sektoren
	}

	private void changeOptionsForContainerAndValue(List<SudokuCell> row, Integer value) {
		row.stream().filter(cell -> cell.getOptions().contains(value)).forEach(cell -> cell.setValue(value));;
	}


}
