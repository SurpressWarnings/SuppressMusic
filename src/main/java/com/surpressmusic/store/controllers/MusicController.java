package com.surpressmusic.store.controllers;

import com.surpressmusic.store.model.Genre;
import com.surpressmusic.store.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MusicController {

   @Autowired
   private GenreService genreService;

   @GetMapping("/genres")
   public String showGenres(Model model) {
      List<String> genreNames = genreService.getAll().stream()
            .map(Genre::getDisplayName).collect(Collectors.toList());
      model.addAttribute("genreNames", genreNames);
      return "genres";
   }
}
