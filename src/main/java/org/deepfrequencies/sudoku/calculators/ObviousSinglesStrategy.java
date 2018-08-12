package org.deepfrequencies.sudoku.calculators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.deepfrequencies.sudoku.domain.SudokuCell;
import org.deepfrequencies.sudoku.domain.SudokuPlayground;

/**
 * If there is one option in a cell in a row / column / sector which cant be
 * found in another cell in a row / column / sector then its a hit.
 * 
 * @author markus
 */
public class ObviousSinglesStrategy extends AbstractStrategy {

	/**
	 * For every cell for every option check if the touched row / column / sector 
	 * contains this option only once: then its a single.
	 * And then the other options of this cell in this row / column / sector can be deleted.
	 * So its an algorithm which works on row / column / sector.
	 * 
	 * @param applyTo The playground on which the strategy is applied.
	 */
	SudokuPlayground ground;
	@Override
	public void applyStrategy(SudokuPlayground applyTo) {
		applyTo.clearOptions();
		applyTo.calculateOptions();
		applyTo.setSingleOptionsAsValues();
	}

	public void applyStrategyDeprecated(SudokuPlayground applyTo) {
		ground = applyTo;
		// for initialization
		ground.calculateOptions();
		applyToContainer(applyTo.getRows().values());
		applyToContainer(applyTo.getColumns().values());
		applyToContainer(applyTo.getSectors().values());
		applyTo.removeInvalidOptions();
	}
	
	private void applyToContainer(Collection<List<SudokuCell>> collectionOfCellLists) {	
		for(List<SudokuCell> cellList : collectionOfCellLists) {
			List<Integer> options = new ArrayList<>();
			for(SudokuCell cell : cellList) {
				options.addAll(cell.getOptions());
			}
			//map 1..9 to occurrences in a row / column / sector
			Map<Integer, Long> counters = options.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
/*
			for (Map.Entry<Integer, Long> entry : counters.entrySet()) {
				Integer key = entry.getKey();
				if (entry.getValue() == 1) {
					changeOptionsForContainerAndValue(row, key);
				}
			}
*/
			// Java 8 Solution for block above
			counters.entrySet().stream().filter(i -> i.getValue()==1).forEach(i -> changeOptionsForContainerAndValue(cellList, i.getKey()));
		}
	}

	private void changeOptionsForContainerAndValue(List<SudokuCell> cellList, Integer oneToNine) {
		// filter can only find one cell per cellList
		cellList.stream().filter(cell -> cell.getOptions().contains(oneToNine)).forEach(cell -> this.calculateOptions(cell, oneToNine));
		//cell -> cell.setValue(oneToNine));;
	}
	
	private void calculateOptions(SudokuCell cell, Integer value) {
		cell.setValue(value);
		// every time a cell gets a value, ALL options must be re-calculated
		ground.calculateOptions();
	}

}
