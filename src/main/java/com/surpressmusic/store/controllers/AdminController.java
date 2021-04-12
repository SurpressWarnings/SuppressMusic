package com.surpressmusic.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.surpressmusic.store.model.Genre;
import com.surpressmusic.store.services.GenreService;

@Controller
public class AdminController {
	
	@Autowired
	GenreService genreServ;

   @GetMapping("/admin")
   public String getAdmin() {
      return "admin";
   }
   
   @GetMapping("/genre/add")
   public String showAddGenre() {
	   return "genre_add";
   }
   
   @PostMapping("/genre/add")
   public String processAddGenre(@RequestParam String genretype) {
	   
	   Genre newGenre = new Genre();
	   newGenre.setGenreType(genretype);
	   genreServ.updateGenre(newGenre);
	   return "admin";
   }
   
   @GetMapping("/genre/edit")
   public String showEditGenre() {
	   return "genre_edit";
   }
   
   @PostMapping("/genre/edit")
   public String processEditGenre() {
	   return "";
   }
   
   @GetMapping("/genre/delete")
   public String showDeleteGenre() {
	   return "";
   }
   
   @PostMapping("/genre/delete")
   public String processDeleteGenre() {
	   return "";
   }
}
