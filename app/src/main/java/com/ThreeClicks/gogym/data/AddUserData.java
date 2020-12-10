package com.ThreeClicks.gogym.data;

public class AddUserData {
    String userType,userName,userMobileNo,userEmail,enterEmailId,enterPassword;
    boolean home,enrollment,user,plan,tax,invoice,trainer,member,enquiry,sms,diet,measurement,slider,export,notice,exercise;

    public AddUserData(String userType, String userName, String userMobileNo, String userEmail, boolean home, boolean enrollment, boolean user, boolean plan, boolean tax, boolean invoice, boolean trainer, boolean member, boolean enquiry, boolean sms, boolean diet, boolean measurement, boolean slider, boolean export, boolean notice, boolean exercise) {
        this.userType = userType;
        this.userName = userName;
        this.userMobileNo = userMobileNo;
        this.userEmail = userEmail;
        this.home = home;
        this.enrollment = enrollment;
        this.user = user;
        this.plan = plan;
        this.tax = tax;
        this.invoice = invoice;
        this.trainer = trainer;
        this.member = member;
        this.enquiry = enquiry;
        this.sms = sms;
        this.diet = diet;
        this.measurement = measurement;
        this.slider = slider;
        this.export = export;
        this.notice = notice;
        this.exercise = exercise;
    }

    public String getUserType() {
        return userType;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserMobileNo() {
        return userMobileNo;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getEnterEmailId() {
        return enterEmailId;
    }

    public String getEnterPassword() {
        return enterPassword;
    }

    public boolean isHome() {
        return home;
    }

    public boolean isEnrollment() {
        return enrollment;
    }

    public boolean isUser() {
        return user;
    }

    public boolean isPlan() {
        return plan;
    }

    public boolean isTax() {
        return tax;
    }

    public boolean isInvoice() {
        return invoice;
    }

    public boolean isTrainer() {
        return trainer;
    }

    public boolean isMember() {
        return member;
    }

    public boolean isEnquiry() {
        return enquiry;
    }

    public boolean isSms() {
        return sms;
    }

    public boolean isDiet() {
        return diet;
    }

    public boolean isMeasurement() {
        return measurement;
    }

    public boolean isSlider() {
        return slider;
    }

    public boolean isExport() {
        return export;
    }

    public boolean isNotice() {
        return notice;
    }

    public boolean isExercise() {
        return exercise;
    }
}
