package com.pozdnyakov;

import java.util.Map;

public class MeterReading {
    private User user;
    private int year;
    private int month;
    private Map<String, Integer> readings; // Показания счетчиков

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Map<String, Integer> getReadings() {
        return readings;
    }

    public void setReadings(Map<String, Integer> readings) {
        this.readings = readings;
    }

    public MeterReading(User user, int year, int month, Map<String, Integer> readings) {
        this.user = user;
        this.year = year;
        this.month = month;
        this.readings = readings;
    }
}
