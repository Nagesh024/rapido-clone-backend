package com.rapido.analyticsservice.dto;

public class TrendResponse {

    private Long todayEvents;

    private Long last7DaysEvents;

    private Long last30DaysEvents;

    public Long getTodayEvents() {
        return todayEvents;
    }

    public void setTodayEvents(Long todayEvents) {
        this.todayEvents = todayEvents;
    }

    public Long getLast7DaysEvents() {
        return last7DaysEvents;
    }

    public void setLast7DaysEvents(Long last7DaysEvents) {
        this.last7DaysEvents = last7DaysEvents;
    }

    public Long getLast30DaysEvents() {
        return last30DaysEvents;
    }

    public void setLast30DaysEvents(Long last30DaysEvents) {
        this.last30DaysEvents = last30DaysEvents;
    }
}