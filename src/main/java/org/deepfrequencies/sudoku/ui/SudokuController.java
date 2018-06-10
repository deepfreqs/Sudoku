package org.deepfrequencies.sudoku.ui;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/sudoku")
public class SudokuController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView getRequest(@RequestParam(value = "action", required = false, defaultValue = "new") String action,
    		@ModelAttribute("sudokuForm") SudokuForm sudokuForm, BindingResult result, ModelMap model) {
    	if (logger.isInfoEnabled()) {
        	logger.info("action = {0}", action);
        	logger.info(sudokuForm.toString());
    	}
    	if ("new".equals(action)) {
    		sudokuForm = SudokuResponseBuilder.getBuilder().newSudokuForm();
    	}
    	if ("next".equals(action)) {
    		sudokuForm = SudokuResponseBuilder.getBuilder().takeAStep(sudokuForm);
    	}
    	if ("load".equals(action)) {
    		sudokuForm = SudokuResponseBuilder.getBuilder().loadFromString(sudokuForm.getPlayThis());
    	}	
    	if ("import".equals(action)) {
    		sudokuForm = SudokuResponseBuilder.getBuilder().loadFromString(sudokuForm.getImportSudoku());
    	}	
    	if ("solve".equals(action)) {
    		sudokuForm = SudokuResponseBuilder.getBuilder().tryToSolve(sudokuForm);
    	}	
    	model.addAttribute(sudokuForm);
    	
    	model.addAttribute("sudokuList", getListOfSudokus());
    	return new ModelAndView("sudoku", model);
    }
    
	Map getListOfSudokus() {
		Map sudokuList = new LinkedHashMap();
		sudokuList.put("", "");
		sudokuList.put("000079065000003002005060093340050106000000000608020059950010600700600000820390000", "easy peasy");
		sudokuList.put("300401076602500040000006210500000180700010002021000007054300000090004608830109004", "test piece");
		sudokuList.put("000012300000400000105006700306000070700080009020000108001500403000001000003890000", "hoddel");
		return sudokuList;
	}


}
