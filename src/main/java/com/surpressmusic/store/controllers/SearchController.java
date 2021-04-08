package com.surpressmusic.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {

   @GetMapping("/admin")
   public String getAdmin() {
      return "admin";
   }


}