package com.fitSecret.fitSecretMobileApp.data;

public class AddSmsTemplateData {
    String smsName,smsContent;

    public AddSmsTemplateData(String smsName, String smsContent) {
        this.smsName = smsName;
        this.smsContent = smsContent;
    }

    public String getSmsName() {
        return smsName;
    }

    public String getSmsContent() {
        return smsContent;
    }
}
