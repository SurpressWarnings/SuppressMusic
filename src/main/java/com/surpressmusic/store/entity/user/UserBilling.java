package com.surpressmusic.store.entity.user;

import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name = "user_billing_info")
public class UserBilling {

   @Id
   @Column(name = "user_billing_id")
   private Long id;

   @Column(name="first_name", nullable = false)
   private String firstName;

   @Column(name="last_name", nullable = false)
   private String lastName;

   @Column(name="email")
   private String email;

   @Column(name = "street_address", nullable = false)
   private String streetAddress;

   @Column(name = "city", nullable = false)
   private String city;

   @Column(name = "state", nullable = false)
   private String state;

   @Column(name = "zipcode", nullable = false)
   private String zipcode;

   @Column(name = "phone_number", nullable = false)
   private String phoneNumber;

   @Column(name = "cc_number")
   private String ccNumber;

   public UserBilling(){}

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getStreetAddress() {
      return streetAddress;
   }

   public void setStreetAddress(String streetAddress) {
      this.streetAddress = streetAddress;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public String getZipcode() {
      return zipcode;
   }

   public void setZipcode(String zipcode) {
      this.zipcode = zipcode;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public String getCcNumber() {
      return ccNumber;
   }

   public void setCcNumber(String ccNumber) {
      this.ccNumber = ccNumber;
   }

}
