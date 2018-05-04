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
    	if ("simple".equals(action)) {
    		sudokuForm.getImportSudoku();
    	}
    		
    	model.addAttribute(sudokuForm);
    	return new ModelAndView("sudoku", model);
    }


    //    @RequestMapping("/sudoku-1")
    public ModelAndView controll() {
    	HashMap<String,String> variables = new HashMap<>();
    	variables.put("a1", "7");
    	variables.put("b1", "");
    	variables.put("c1", "3");
    	variables.put("d1", "");
    	variables.put("e1", "9");
    	variables.put("f1", "5");
    	variables.put("g1", "");
    	variables.put("h1", "8");
    	variables.put("i1", "");
    	return new ModelAndView("sudoku", variables);
    }
  }
