package com.surpressmusic.store.exceptions;

import java.util.function.Supplier;

public class MusicNotFoundException extends RuntimeException implements Supplier<String> {

   private String fieldNotFound;

   public MusicNotFoundException() {
      super();
   }

   public MusicNotFoundException(String fieldNotFound) {
      super();
      this.fieldNotFound = fieldNotFound;
   }

   public String getFieldNotFound() {
      return fieldNotFound;
   }

   @Override
   public String get() {
      return fieldNotFound;
   }
}
