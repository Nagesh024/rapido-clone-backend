package com.rapido.search.dto;

import java.util.List;

public class TrendingResponse {

    private List<String> today;
    private List<String> weekly;
    private List<String> monthly;

    public List<String> getToday() {
        return today;
    }

    public void setToday(List<String> today) {
        this.today = today;
    }

    public List<String> getWeekly() {
        return weekly;
    }

    public void setWeekly(List<String> weekly) {
        this.weekly = weekly;
    }

    public List<String> getMonthly() {
        return monthly;
    }

    public void setMonthly(List<String> monthly) {
        this.monthly = monthly;
    }
}