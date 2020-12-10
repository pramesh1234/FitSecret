package com.fitSecret.fitSecretMobileApp.data;

public class AddPlanData {
    String planName;
    String planType;
    String planAmount;
    String planDuration;
    String planDescription;

    public AddPlanData(String planName, String planType, String planAmount, String planDuration, String planDescription) {
        this.planName = planName;
        this.planType = planType;
        this.planAmount = planAmount;
        this.planDuration = planDuration;
        this.planDescription = planDescription;
    }

    public String getPlanName() {
        return planName;
    }

    public String getPlanType() {
        return planType;
    }

    public String getPlanAmount() {
        return planAmount;
    }

    public String getPlanDuration() {
        return planDuration;
    }

    public String getPlanDescription() {
        return planDescription;
    }
}
