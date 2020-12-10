package com.fitSecret.fitSecretMobileApp.data;

public class AddBatchData {
    String batchName;
    String batchLimit;
    String batchTime;

    public AddBatchData(String batchName, String batchLimit, String batchTime) {
        this.batchName = batchName;
        this.batchLimit = batchLimit;
        this.batchTime = batchTime;
    }

    public String getBatchName() {
        return batchName;
    }

    public String getBatchLimit() {
        return batchLimit;
    }

    public String getBatchTime() {
        return batchTime;
    }
}
