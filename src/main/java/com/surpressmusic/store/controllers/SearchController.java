package com.surpressmusic.store.controllers;

import com.surpressmusic.store.model.product.*;
import com.surpressmusic.store.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

   @Autowired
   private SearchService searchService;

   @GetMapping("/search")
   public String getSearch() {
      return "search";
   }

   @GetMapping("/search/results")
   public String search(@RequestParam String query, Model model) {

      List<Song> songResults = searchService.searchSongs(query);
      List<Album> albumResults  = searchService.searchAlbums(query);
      List<Artist> artistResults = searchService.searchArtists(query);
      List<Format> formatResults = searchService.searchFormats(query);
      List<Genre> genreResults = searchService.searchGenres(query);

      model.addAttribute("query", query);
      model.addAttribute("songResults", songResults);
      model.addAttribute("albumResults", albumResults);
      model.addAttribute("artistResults", artistResults);
      model.addAttribute("formatResults", formatResults);
      model.addAttribute("genreResults", genreResults);

      return "search_results";
   }

}