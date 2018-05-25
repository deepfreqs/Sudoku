package org.deepfrequencies.sudoku.ui;

import java.util.HashMap;

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
    public ModelAndView getNextStep(@RequestParam(value = "action", required = false, defaultValue = "new") String action,
    		@ModelAttribute("sudokuForm") SudokuForm sudokuForm, BindingResult result, ModelMap model) {
    	if (logger.isInfoEnabled()) {
        	logger.info("action = {0}", action);
        	logger.info(sudokuForm.toString());
    	}
    	if ("new".equals(action)) {
    		sudokuForm = SudokuResponseBuilder.getBuilder().newSudokuForm();
    	}
    	if ("next".equals(action)) {
    		sudokuForm = SudokuResponseBuilder.getBuilder().calculateNextStep(sudokuForm);
    	}
    	if ("load".equals(action)) {
    		sudokuForm = SudokuResponseBuilder.getBuilder().loadFromString(sudokuForm.getImportSudoku());
    	}	
    	model.addAttribute(sudokuForm);
    	return new ModelAndView("sudoku", model);
    }

}
