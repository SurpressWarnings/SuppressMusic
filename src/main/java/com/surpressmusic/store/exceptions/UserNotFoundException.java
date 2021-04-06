package com.surpressmusic.store.exceptions;

public class UserNotFoundException extends RuntimeException {
   
   private String username;

   public UserNotFoundException() {
      super();
   }

   public UserNotFoundException(String username) {
      super();
      this.username = username;
   }

   public String getUsername() {
      return username;
   }
}
