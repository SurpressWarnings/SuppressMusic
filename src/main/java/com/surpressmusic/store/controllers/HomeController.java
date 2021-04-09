package com.surpressmusic.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.surpressmusic.store.model.User;
import com.surpressmusic.store.services.UserService;


@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;


   @GetMapping({"/", "index"})
   public String home() {
      return "index";
   }
   
   @GetMapping("/login")
   public String login() {
	   return "login";
   }
   
   @PostMapping("/login")
   public String processLogin() {
	   return "shoppingcart"; // Placeholder page name
   }
   
   @GetMapping("/register")
   public String register() {
	   return "register";
   }
   
   @PostMapping("/register")
   public String addUsers(ModelMap model, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String username, 
   		@RequestParam String psw) {
//   	User u = new User();
//   	u.setFirstName(firstname);
//   	u.setLastName(lastname);
//   	u.setUsername(username);
//   	u.setPassword(psw);
	// Use User's constructor to create user
	   
	   	User u = new User(username, psw, firstname, lastname);
	   	model.addAttribute("user", u);
	   	userService.saveUser(u);
	   	return "usersuccess";
   }  
   
   
   @GetMapping("/userdetails")
   public String userdetails() {
	   return "userdetails";
   }

}
