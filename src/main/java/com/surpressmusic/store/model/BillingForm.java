package com.surpressmusic.store.model;

public class BillingForm {

   private String firstName;
   private String lastName;

   private String streetAddress;
   private String city;
   private String state;
   private String zipcode;

   private String email;
   private String phone;

   private Boolean isValid;

   public BillingForm() {}

   public BillingForm(String firstName, String lastName, String streetAddress,
                      String city, String state, String zipcode, String email, String phone) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.streetAddress = streetAddress;
      this.city = city;
      this.state = state;
      this.zipcode = zipcode;
      this.email = email;
      this.phone = phone;
   }

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

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public Boolean isValid() {
      return isValid;
   }

   public void setValid(Boolean valid) {
      isValid = valid;
   }
}
