package com.surpressmusic.store.model;

public class UserInfo {
   private String firstName;
   private String lastName;
   private String email;
   private String phone;

   private Address address;

   private boolean valid;

   public UserInfo() {}

   public UserInfo(BillingForm billingForm) {
      this.firstName = billingForm.getFirstName();
      this.lastName = billingForm.getLastName();
      this.address = billingForm.getAddress();
      this.email = billingForm.getEmail();
      this.phone = billingForm.getPhone();
      this.valid = billingForm.isValid();
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public boolean isValid() {
      return valid;
   }

   public void setValid(boolean valid) {
      this.valid = valid;
   }

}
