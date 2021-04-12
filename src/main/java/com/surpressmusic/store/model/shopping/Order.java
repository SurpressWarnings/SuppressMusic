package com.surpressmusic.store.model.shopping;

import javax.persistence.*;

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
