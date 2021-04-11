package com.surpressmusic.store.controllers;

import com.surpressmusic.store.services.UserDetailsImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.surpressmusic.store.entity.user.User;
import com.surpressmusic.store.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;

	@Autowired
   private UserDetailsImplService detailsService;

   @GetMapping({"/", "index"})
   public String home() {
      return "index";
   }
   
   @GetMapping("/login")
   public String login() {
	   return "login";
   }
   
   @GetMapping("/register")
   public String register() {
	   return "register";
   }
   
   @PostMapping("/register")
   public String addUsers(ModelMap model, @RequestParam String username,
   		@RequestParam String psw) {
   	User u = new User();
   	u.setUsername(username);
   	u.setPassword(psw);
   	model.addAttribute("user", u);
   	userService.registerUser(u);

   	model.addAttribute("registerSuccess", true);
   	return "login";
   }
}
