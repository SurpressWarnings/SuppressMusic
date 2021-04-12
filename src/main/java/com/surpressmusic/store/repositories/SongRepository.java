package com.surpressmusic.store.repositories;

import com.surpressmusic.store.model.product.Album;
import com.surpressmusic.store.model.product.Genre;
import com.surpressmusic.store.model.product.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

   List<Song> findAll();

   Song findBySongTitle(String title);

   Song findSongById(Integer id);

   @Query(value = "SELECT s from Song s WHERE s.songTitle LIKE %:search% ORDER BY s.songTitle")
   List<Song> findAllBySongTitleLike(String search);

   @Query(value = "SELECT s from Song s WHERE s.album.id = :id ORDER BY s.songTitle")
   List<Song> findAllByAlbum(Integer id);

   @Query(value = "SELECT s from Song s WHERE s.artist.id = :id ORDER BY s.songTitle")
   List<Song> findAllByArtist(Integer id);

   @Query(value = "SELECT s from Song s WHERE s.genre.id = :id ORDER BY s.songTitle")
   List<Song> findAllByGenre(Integer id);

   @Query(value = "SELECT s from Song s WHERE s.format.id = :id ORDER BY s.songTitle")
   List<Song> findAllByFormat(Integer id);

   List<Song> findAllByPriceGreaterThanEqualAndPriceLessThanEqualOrderBySongTitle(float min, float max);

   @Query(value = "SELECT s FROM Song s WHERE s.price >= :min AND s.price <= :max")
   List<Song> findByPrice(Integer min, Integer max);
}
