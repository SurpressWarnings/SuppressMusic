package com.surpressmusic.store.repositories;

import com.surpressmusic.store.model.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends CrudRepository<Song, Integer> {

   List<Song> findAll();

   Song findBySongTitle(String title);
}
