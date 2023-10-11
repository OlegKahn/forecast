package com.example.forecast.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Weather {
    private double latitude;
    private double longitude;
    private double elevation;
    private double generationtime_ms;
    private int utc_offset_seconds;
    private String timezone;
    private String timezone_abbreviation;
    private Hourly hourly;
    private HourlyUnit hourly_units;
    private Daily daily;
    private DailyUnit daily_units;
    private CurrentWeather current_weather;
}
