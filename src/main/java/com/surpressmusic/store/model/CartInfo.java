package com.surpressmusic.store.model;

import java.util.ArrayList;
import java.util.List;

public class CartInfo {

   private int orderNum;
   private UserInfo userInfo;

   private final List<CartLineInfo> cartLines = new ArrayList<>();

   public CartInfo() {}

   public int getOrderNum() {
      return orderNum;
   }
   public void setOrderNum(int orderNum) {
      this.orderNum = orderNum;
   }

   public UserInfo getUserInfo() {
      return userInfo;
   }

   public void setUserInfo(UserInfo userInfo) {
      this.userInfo = userInfo;
   }

   public List<CartLineInfo> getCartLines() {
      return this.cartLines;
   }

   private CartLineInfo findLineById(Integer id) {
      for (CartLineInfo line : this.cartLines) {
         if (line.getSongInfo().getId() == id) {
            return line;
         }
      }
      return null;
   }

   public void addProduct(SongInfo songInfo, int quantity) {
      CartLineInfo line = this.findLineById(songInfo.getId());

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
   public void updateProduct(Integer id, int quantity) {
      CartLineInfo line = this.findLineById(id);

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
      return this.userInfo != null && this.userInfo.isValid();
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