package com.surpressmusic.store.model;

import java.util.Arrays;
import java.util.List;

public class UserInfo {
   private String firstName;
   private String lastName;
   private String streetAddress;
   private String city;
   private String state;
   private String zipcode;
   private String email;
   private String phone;

   private List<String> userInfoFields;

   private boolean valid;

   public UserInfo() {}

   public UserInfo(BillingForm billingForm) {
      this.firstName = billingForm.getFirstName();
      this.lastName = billingForm.getLastName();
      this.streetAddress = billingForm.getStreetAddress();
      this.city = billingForm.getCity();
      this.state = billingForm.getState();
      this.zipcode = billingForm.getZipcode();
      this.email = billingForm.getEmail();
      this.phone = billingForm.getPhone();

      this.userInfoFields = Arrays.asList(firstName, lastName, streetAddress,
            city, state, zipcode, email, phone);

      this.valid = billingForm.isValid();
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

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public void setAllFields(List<String> userInfoFields) {
      this.userInfoFields = userInfoFields;
   }

   public List<String> getAllFields() {
      return userInfoFields;
   }

   public boolean isValid() {
      return valid;
   }

   public void setValid(boolean valid) {
      this.valid = valid;
   }

}
