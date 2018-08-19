package org.deepfrequencies.sudoku.ui;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

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
	
	@Resource(name="responseBuilder")	
	SudokuResponseBuilder responseBuilder;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView getRequest(@RequestParam(value = "action", required = false, defaultValue = "new") String action,
    		@RequestParam(value = "strategy", required = false, defaultValue = "ObviousSinglesStrategy") String strategy,
    		@ModelAttribute("sudokuForm") SudokuForm sudokuForm, BindingResult result, ModelMap model) {
    	if (logger.isInfoEnabled()) {
        	logger.info("action = " + action);
        	logger.info("strategy = " + strategy);
    	}
    	logger.debug(sudokuForm.toString());
    	if ("new".equals(action)) {
    		sudokuForm = responseBuilder.newSudokuForm();
    	}
    	if ("next".equals(action)) {
    		sudokuForm = responseBuilder.takeAStep(sudokuForm);
    	}
    	if ("load".equals(action)) {
    		sudokuForm = responseBuilder.loadFromString(sudokuForm.getPlayThis());
    	}	
    	if ("import".equals(action)) {
    		sudokuForm = responseBuilder.loadFromString(sudokuForm.getImportSudoku());
    	}	
    	if ("solve".equals(action)) {
    		sudokuForm = responseBuilder.tryToSolve(sudokuForm, strategy);
    	}	
    	model.addAttribute(sudokuForm);
    	
    	model.addAttribute("sudokuList", getListOfSudokus());
    	model.addAttribute("strategyList", getListOfStrategies());
    	return new ModelAndView("sudoku", model);
    }
    
	Map<String,String> getListOfSudokus() {
		Map<String,String> sudokuList = new LinkedHashMap<String,String>();
		sudokuList.put("", "");
		sudokuList.put("000079065000003002005060093340050106000000000608020059950010600700600000820390000", "easy peasy");
		sudokuList.put("300401076602500040000006210500000180700010002021000007054300000090004608830109004", "test piece");
		sudokuList.put("000012300000400000105006700306000070700080009020000108001500403000001000003890000", "hoddel");
		sudokuList.put("000105000140000670080002400063070010900000003010090520007200080026000035000409000", "dings");
		return sudokuList;
	}

	Map<String,String> getListOfStrategies() {
		Map<String,String> list = new LinkedHashMap<String,String>();
		list.put("ObviousSinglesStrategy", "set obvious singles as values");
		return list;
	}

}
