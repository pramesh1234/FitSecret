package com.fitSecret.fitSecretMobileApp.data;

public class AddTaxData {
    String taxName;
    String taxPercentage;

    public AddTaxData(String taxName, String taxPercentage) {
        this.taxName = taxName;
        this.taxPercentage = taxPercentage;
    }

    public String getTaxName() {
        return taxName;
    }

    public String getTaxPercentage() {
        return taxPercentage;
    }
}
