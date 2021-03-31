package com.todo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.todo.login.LoginService;

@Controller
public class ToDoController {
	
	@Autowired
	private ToDoService service;
	
	@RequestMapping(value = "/list-todos", method= RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		model.addAttribute("todos", service.retreiveTodos("todo"));
		return "list-todos";
	} 
	
	
	

}
