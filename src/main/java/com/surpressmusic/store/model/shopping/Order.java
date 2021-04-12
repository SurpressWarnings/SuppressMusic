package com.surpressmusic.store.model.shopping;

import com.surpressmusic.store.model.product.Song;

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

   @OneToMany
   @JoinColumn(name = "song_id")
   private List<Song> cartSongs;


}
