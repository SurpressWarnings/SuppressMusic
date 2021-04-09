package com.surpressmusic.store.controllers;

import com.surpressmusic.store.entity.products.Album;
import com.surpressmusic.store.entity.products.Artist;
import com.surpressmusic.store.entity.products.Song;
import com.surpressmusic.store.services.AlbumService;
import com.surpressmusic.store.services.ArtistService;
import com.surpressmusic.store.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

   @Autowired
   private SongService songService;

   @Autowired
   private ArtistService artistService;

   @Autowired
   private AlbumService albumService;

   @GetMapping("/search")
   public String getSearch() {
      return "search";
   }

   @PostMapping("/searchSong")
   public String searchSong(@RequestParam String queryStr,
                            @RequestParam String songQuery, Model model) {

      queryStr = queryStr.toLowerCase();

      switch (songQuery) {
         case "title":
            Song foundSong = songService.getSongByTitle(queryStr);
            model.addAttribute("titleResult", foundSong);
            break;

         case "artist":
            Artist foundArtist = artistService.getArtistByName(queryStr);
            List<Song> artistSongs = songService.getSortedSongsByArtist(foundArtist.getName());
            model.addAttribute("artistResults", artistSongs);
            break;

         case "album":
            Album foundAlbum = albumService.getByTitle(queryStr);
            List<Song> albumSongs= foundAlbum.getSongs();
            model.addAttribute("albumResults", albumSongs);
            break;
      }

      return "search_results";
   }

   @PostMapping("/searchArtist")
   public String searchArtist(@RequestParam String artistQuery, Model model) {

      return "search_results";
   }

   @PostMapping("/searchAlbum")
   public String searchAlbum(@RequestParam String albumQuery, Model model) {

      return "search_results";
   }
}