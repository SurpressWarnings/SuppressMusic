package com.surpressmusic.store.repositories;

import com.surpressmusic.store.model.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<Song, Integer> {

}
