package com.surpressmusic.store.controllers;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import com.surpressmusic.store.model.user.User;
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
   public String processLogin(@RequestParam String username, @RequestParam String password, ModelMap model) {
	
		if(!userService.validateEmptyInput(username) || !userService.validateEmptyInput(password))
		{
			return "error";
		}
		
		if(!userService.validateCredentials(username, password))
		{
			return "error";
		}
		
		return "browse"; // Redirect to browse until shopping cart is implemented
   }
   
   @GetMapping("/default")
   public String defaultAfterLogin()
   {
	   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	   
	   if(auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")))
	   {
		   return "redirect:/admin/";
	   }

	   return "redirect:/browse/";
   }
   
   @GetMapping("/register")
   public String register() {
	   return "register";
   }
   
   @PostMapping("/register")
   public String addUsers(ModelMap model, @RequestParam String username,
   		@RequestParam String psw) {
//   	User u = new User();
//   	u.setFirstName(firstname);
//   	u.setLastName(lastname);
//   	u.setUsername(username);
//   	u.setPassword(psw);
	// Use User's constructor to create user
	   
	   	User u = new User(username, psw);
	   	model.addAttribute("user", u);
	   	userService.registerUser(u);
	   	return "login";
   }  
   
   @GetMapping("/logout")
   public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       if (auth != null){    
           new SecurityContextLogoutHandler().logout(request, response, auth);
       }
       return "/";
   }
   
   @GetMapping("/userdetails")
   public String userdetails() {
	   return "userdetails";
   }

}