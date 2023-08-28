package com.prodapt.learningspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class StudentController {
	
	  @Autowired
	  private ApplicationContext ctx;
	  
	  @GetMapping("/student")
	  public String showForm() {
	    return "student";
	  }
	  
	  @PostMapping("/")
	  public String processForm(@RequestParam("name") String name,
			  					@RequestParam("score") String score,
			  					Model model) {
		  model.addAttribute("name", name);
		  model.addAttribute("score",score);
		  return "result";
	  }
	  

}
