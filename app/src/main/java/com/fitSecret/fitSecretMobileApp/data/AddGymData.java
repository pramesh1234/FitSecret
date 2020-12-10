package com.fitSecret.fitSecretMobileApp.data;

public class AddGymData {
    String displayName,addressLine1,addressLine2,city,state;

    public AddGymData(String displayName, String addressLine1, String addressLine2, String city, String state) {
        this.displayName = displayName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
