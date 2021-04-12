package com.surpressmusic.store.controllers;

import com.surpressmusic.store.model.product.Song;
import com.surpressmusic.store.model.shopping.Item;
import com.surpressmusic.store.model.shopping.Order;
import com.surpressmusic.store.model.user.User;
import com.surpressmusic.store.model.user.UserBilling;
import com.surpressmusic.store.services.OrderService;
import com.surpressmusic.store.services.SongService;
import com.surpressmusic.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

   @Autowired
   private SongService songService;

   @Autowired
   private UserService userService;

   @Autowired
   private OrderService orderService;

   @GetMapping("/cart")
   public String viewCart() {
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

         float total = getTotal(cart);

         session.setAttribute("total", total);
         session.setAttribute("cart", cart);
      }
      return "redirect:/cart";
   }

   @GetMapping(value = "/cart/remove")
   public String remove(@RequestParam String id,
                        HttpSession session) {
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

   private float getTotal(List<Item> items) {
      float total = 0;
      for (Item item : items) {
         total += item.getPrice();
      }
      return total;
   }

   @GetMapping("/checkout")
   public String checkout(HttpSession session,
                           Model model) {
      List<Item> items = (List<Item>) session.getAttribute("cart");
      float total = getTotal(items);

      model.addAttribute("billInfo", new UserBilling());
      session.setAttribute("total", total);
      session.setAttribute("cart", items);

      return "checkout";
   }

   @PostMapping("/checkout")
   public String postCheckout(@ModelAttribute UserBilling billInfo,
                               HttpSession session,
                               Authentication auth) {

      User user = userService.getUserByUsername(auth.getName());

      List<Item> items = (List<Item>) session.getAttribute("cart");

      float total = 0;
      if (session.getAttribute("total") != null) {
         total = (float) session.getAttribute("total");
      }

      Order order = new Order();
      order.setStatus("ordered");
      order.setTotal(total);
      order.setUserBilling(billInfo.toList());
      order.setItems(items);
      order.setUser(user);

      orderService.orderMusic(order);

      return "ordersuccess";
   }
}