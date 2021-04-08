package com.surpressmusic.store.services;

import com.surpressmusic.store.model.Format;
import com.surpressmusic.store.repositories.FormatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormatService {

   @Autowired
   private FormatRepository formatRepo;

   public List<Format> getAllFormats() { return formatRepo.findAll(); }
}
