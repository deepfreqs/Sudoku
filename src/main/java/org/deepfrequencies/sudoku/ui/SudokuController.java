package org.deepfrequencies.sudoku.ui;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/sudoku")
public class SudokuController {
        
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView get(ModelAndView modelAndView) {
    	return new ModelAndView("sudoku", SudokuResponseBuilder.getBuilder().createSudokuUI());
    }

    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView post(ModelAndView modelAndView) {
    	System.out.println(modelAndView.toString());
    	return new ModelAndView("sudoku", SudokuResponseBuilder.getBuilder().createSudokuUI());
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
