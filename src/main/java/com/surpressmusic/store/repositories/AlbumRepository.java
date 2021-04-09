package com.surpressmusic.store.repositories;

import com.surpressmusic.store.entity.products.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

   List<Album> findAll();

   Album findByTitle(String title);

   List<Album> findByGenre(String genre);

   List<Album> findByArtist(String artist);

//   Album findBySong(String song);
}
