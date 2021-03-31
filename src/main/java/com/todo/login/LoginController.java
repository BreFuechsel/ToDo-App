package com.todo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.todo.login.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	
	LoginService Service;
	
	/* @RequestMapping(value = "/login")
	@ResponseBody
	public String sayHello() {
		return "Hello World";
	} */
	
	@RequestMapping(value = "/login", method= RequestMethod.GET)
	public String showLoginPage() {
		return "login"; //WEB-INF/views/login.jsp
	} 
	
	@RequestMapping(value = "/login", method= RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String name,
			@RequestParam String password,
			ModelMap model) {
		
		if(!Service.validateUser(name, password)) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		
		model.put("name", name);
		model.put("password", password);
		return "welcome";
	} 
	
	

}
