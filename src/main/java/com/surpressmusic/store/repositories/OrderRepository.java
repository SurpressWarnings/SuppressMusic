package com.surpressmusic.store.repositories;

import com.surpressmusic.store.model.shopping.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
   List<Order> findAll();
}
