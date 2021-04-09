package com.surpressmusic.store.model;

import com.surpressmusic.store.entity.user.User;
import com.surpressmusic.store.entity.user.UserDetailsImpl;

import java.util.ArrayList;
import java.util.List;

public class CartInfo {

   private int orderNum;
   private User user;
   private UserDetailsImpl userDetails;

   private final List<CartLineInfo> cartLines = new ArrayList<>();

   public CartInfo() {}

   public void validate() {}

   public int getOrderNum() {
      return orderNum;
   }
   public void setOrderNum(int orderNum) {
      this.orderNum = orderNum;
   }

   public User getUser() {
      return user;
   }
   public UserDetailsImpl getUserDetails() {
      return userDetails;
   }

   public List<CartLineInfo> getCartLines() {
      return this.cartLines;
   }

   private CartLineInfo findLineByCode(Long id) {
      for (CartLineInfo line : this.cartLines) {
         if (line.getSongInfo().getId().equals(id)) {
            return line;
         }
      }
      return null;
   }

   public void addProduct(SongInfo songInfo, int quantity) {
      CartLineInfo line = this.findLineByCode(songInfo.getId());

      if (line == null) {
         line = new CartLineInfo();
         line.setQuantity(0);
         line.setSongInfo(songInfo);
         this.cartLines.add(line);
      }
      int newQuantity = line.getQuantity() + quantity;
      if (newQuantity <= 0) {
         this.cartLines.remove(line);
      } else {
         line.setQuantity(newQuantity);
      }
   }
   public void updateProduct(Long id, int quantity) {
      CartLineInfo line = this.findLineByCode(id);

      if (line != null) {
         if (quantity <= 0) {
            this.cartLines.remove(line);
         } else {
            line.setQuantity(quantity);
         }
      }
   }

   public void removeProduct(SongInfo songInfo) {
      CartLineInfo line = this.findLineById(songInfo.getId());
      if (line != null) {
         this.cartLines.remove(line);
      }
   }

   public boolean isEmpty() {
      return this.cartLines.isEmpty();
   }

   public boolean isValidCustomer() {
      return this.userDetails != null && this.userDetails.isValid();
   }

   public int getQuantityTotal() {
      int quantity = 0;
      for (CartLineInfo line : this.cartLines) {
         quantity += line.getQuantity();
      }
      return quantity;
   }

   public double getAmountTotal() {
      double total = 0;
      for (CartLineInfo line : this.cartLines) {
         total += line.getAmount();
      }
      return total;
   }

   public void updateQuantity(CartInfo cartForm) {
      if (cartForm != null) {
         List<CartLineInfo> lines = cartForm.getCartLines();
         for (CartLineInfo line : lines) {
            this.updateProduct(line.getSongInfo().getId(), line.getQuantity());
         }
      }
   }

}