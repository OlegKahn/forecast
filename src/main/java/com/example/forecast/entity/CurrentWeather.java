package com.example.forecast.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class CurrentWeather {
    private String time;
    private double temperature;
    private int weathercode;
    private double windspeed;
    private int winddirection;
}
