package com.ThreeClicks.gogym.data;

public class AddNoticeData {
    String noticeName,noticeDuration,noticeMember;

    public AddNoticeData(String noticeName, String noticeDuration, String noticeMember) {
        this.noticeName = noticeName;
        this.noticeDuration = noticeDuration;
        this.noticeMember = noticeMember;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public String getNoticeDuration() {
        return noticeDuration;
    }

    public String getNoticeMember() {
        return noticeMember;
    }
}
