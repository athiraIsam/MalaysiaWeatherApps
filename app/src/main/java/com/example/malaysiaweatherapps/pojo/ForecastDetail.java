package com.example.malaysiaweatherapps.pojo;

public class ForecastDetail {
    private String todayName;
    private String minTemp;
    private String maxTemp;
    private String morningAttribute;
    private String afterAttribute;
    private String nightAttribute;
    private int morningImage;
    private int afternoonImage;
    private int nightImage;

    public String getTodayName() {
        return todayName;
    }

    public void setTodayName(String todayName) {
        this.todayName = todayName;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getMorningAttribute() {
        return morningAttribute;
    }

    public void setMorningAttribute(String morningAttribute) {
        this.morningAttribute = morningAttribute;
    }

    public String getAfterAttribute() {
        return afterAttribute;
    }

    public void setAfterAttribute(String afterAttribute) {
        this.afterAttribute = afterAttribute;
    }

    public String getNightAttribute() {
        return nightAttribute;
    }

    public void setNightAttribute(String nightAttribute) {
        this.nightAttribute = nightAttribute;
    }

    public int getMorningImage() {
        return morningImage;
    }

    public void setMorningImage(int morningImage) {
        this.morningImage = morningImage;
    }

    public int getAfternoonImage() {
        return afternoonImage;
    }

    public void setAfternoonImage(int afternoonImage) {
        this.afternoonImage = afternoonImage;
    }

    public int getNightImage() {
        return nightImage;
    }

    public void setNightImage(int nightImage) {
        this.nightImage = nightImage;
    }
}
