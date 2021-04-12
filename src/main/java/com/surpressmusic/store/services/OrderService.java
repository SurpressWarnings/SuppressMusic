package com.surpressmusic.store.services;

import com.surpressmusic.store.model.shopping.Order;
import com.surpressmusic.store.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

   @Autowired
   private OrderRepository orderRepo;

   public void orderMusic(Order order) {
      orderRepo.save(order);
   }
}
