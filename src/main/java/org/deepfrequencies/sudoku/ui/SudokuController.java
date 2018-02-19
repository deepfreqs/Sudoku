package org.deepfrequencies.sudoku.ui;

import java.util.HashMap;
import java.util.Map;

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
        
    @RequestMapping(value = "new", method=RequestMethod.GET)
    public ModelAndView get(ModelAndView modelAndView) {
    	return new ModelAndView("sudoku", SudokuResponseBuilder.getBuilder().createSudokuUI());
    }

    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView getNextStep(@RequestParam(value = "action", required = false, defaultValue = "new") String action,
    		@ModelAttribute("sudokuForm") SudokuForm sudokuForm, ModelMap model, BindingResult result) {
    	System.out.println("action =" + action);
    	System.out.println(sudokuForm.toString());
    	model.addAttribute(sudokuForm);
    	//return "sudoku";
    	return new ModelAndView("sudoku", model);//SudokuResponseBuilder.getBuilder().createSudokuUI());
    }


    //    @RequestMapping("/sudoku-1")
    public ModelAndView controll() {
    	HashMap<String,String> variables = new HashMap<String,String>();
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
