package com.surpressmusic.store.controllers;

import com.surpressmusic.store.model.product.Song;
import com.surpressmusic.store.model.shopping.Item;
import com.surpressmusic.store.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

   @Autowired
   private SongService songService;

   @GetMapping("/cart")
   public String viewCart(HttpSession session) {
      return "cart";
   }

   @GetMapping("/cart/add")
   public String addItem(@RequestParam String id,
                         HttpSession session) {
      Integer intId = Integer.parseInt(id);
      Song song = songService.getSongById(intId);

      if (session.getAttribute("cart") == null) {

         List<Item> cart = new ArrayList<>();
         cart.add(new Item(song, 1));
         session.setAttribute("cart", cart);

      } else {

         List<Item> cart = (List<Item>) session.getAttribute("cart");

         int index = this.exists(intId, cart);

         if (index == -1) {
            cart.add(new Item(song, 1));
         } else {
            int quantity = cart.get(index).getQuantity() + 1;
            cart.get(index).setQuantity(quantity);
         }
         session.setAttribute("cart", cart);
      }
      return "redirect:/cart";
   }

   @GetMapping(value = "/cart/remove")
   public String remove(@RequestParam String id, Model model, HttpSession session) {
      Integer intId = Integer.parseInt(id);
      List<Item> cart = (List<Item>) session.getAttribute("cart");
      int index = this.exists(intId, cart);
      cart.remove(index);
      session.setAttribute("cart", cart);
      return "redirect:/cart";
   }

   private int exists(Integer id, List<Item> cart) {
      for (int i = 0; i < cart.size(); i++) {
         if (cart.get(i).getId() == id) {
            return i;
         }
      }
      return -1;
   }
}