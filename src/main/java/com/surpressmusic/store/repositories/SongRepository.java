package com.surpressmusic.store.repositories;

import com.surpressmusic.store.model.Album;
import com.surpressmusic.store.model.Genre;
import com.surpressmusic.store.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

   List<Song> findAll();

   Song findBySongTitle(String title);

   List<Song> findByAlbum(Album album);

   List<Song> findByArtist(String artist);

   List<Song> findByGenre(Genre genre);

   List<Song> findByFormat(String format);

   @Query(value = "SELECT s FROM Song s WHERE s.price >= :min AND s.price <= :max")
   List<Song> findByPrice(Integer min, Integer max);

}
