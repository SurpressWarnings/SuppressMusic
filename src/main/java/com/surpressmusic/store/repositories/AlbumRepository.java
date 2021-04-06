package com.surpressmusic.store.repositories;

import com.surpressmusic.store.model.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer> {
   Album findByAlbumTitle(String albumTitle);
}
