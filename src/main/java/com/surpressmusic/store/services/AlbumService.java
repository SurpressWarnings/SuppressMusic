package com.surpressmusic.store.services;

import com.surpressmusic.store.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
   @Autowired
   private AlbumRepository albumRepo;


}
