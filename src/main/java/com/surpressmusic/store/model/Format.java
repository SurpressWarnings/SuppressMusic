package com.surpressmusic.store.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="formats")
public class Format {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="format_id")
   private Integer id;

   @Column(name="format_type")
   private String formatType;

   public Integer getId() {
      return id;
   }

   public String getFormatType() {
      return formatType;
   }

   public void setFormatType(String formatType) {
      this.formatType = formatType;
   }
}
