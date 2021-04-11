package com.surpressmusic.store.repositories;

import com.surpressmusic.store.model.product.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

   List<Album> findAll();

   Album findByTitle(String title);

   @Query(value = "SELECT a from Album a WHERE a.title LIKE %:search ORDER BY a.title")
   List<Album> findAllByTitleLike(String search);

   List<Album> findByGenre(String genre);

   List<Album> findByArtist(String artist);

//   Album findBySong(String song);
}
