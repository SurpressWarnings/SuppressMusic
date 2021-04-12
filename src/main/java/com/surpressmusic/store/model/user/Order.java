package com.surpressmusic.store.model.user;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "order_id")
   private Integer id;

   @Column(name = "status")
   private String status;



}
