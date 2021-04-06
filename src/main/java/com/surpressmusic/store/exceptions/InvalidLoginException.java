package com.surpressmusic.store.exceptions;

public class InvalidLoginException extends RuntimeException {

   private String username;

   public InvalidLoginException() {
      super();
   }

   public InvalidLoginException(String username) {
      super();
      this.username = username;
   }

   public String getUsername() {
      return username;
   }
}
