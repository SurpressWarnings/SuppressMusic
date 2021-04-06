package com.surpressmusic.store.repositories;

import com.surpressmusic.store.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

   List<Song> findAll();

   Song findBySongTitle(String title);

   List<Song> findByArtist(String artist);

   List<Song> findByGenre(String genre);

   List<Song> findByFormat(String format);

   @Query(
         value = "SELECT * FROM songs s WHERE s.price >= ?min AND" +
               "s.price <= ?max", nativeQuery = true
   )
   List<Song> findByPrice(Integer min, Integer max);

}
