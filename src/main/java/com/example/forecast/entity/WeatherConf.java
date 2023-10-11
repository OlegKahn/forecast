package com.example.forecast.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class WeatherConf {
    private double latitude;
    private double longitude;
    private double elevation;
    private String[] hourly;
    private String[] daily;
    private boolean current_weather;
    private String temperature_unit;
    private String windspeed_unit;
    private String precipitation_unit;
    private String timeformat;
    private String timezone;
    private byte past_days;
    private byte forecast_days;
    private String start_date;
    private String end_date;
    private String[] models;
    private String cell_selection;
    private String apike;
}
