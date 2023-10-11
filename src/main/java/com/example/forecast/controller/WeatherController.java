package com.example.forecast.controller;

import com.example.forecast.entity.Hourly;
import com.example.forecast.entity.Weather;
import com.example.forecast.entity.WeatherConf;
import com.example.forecast.error.WeatherError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/api/user")
public class WeatherController {

    @Autowired
    RestTemplate restTemplate;

    private final String url = "https://api.open-meteo.com/v1/forecast?";

    @GetMapping("/")
    public String main(ModelMap modelMap) {
        modelMap.addAttribute("conf" ,new WeatherConf());
        return "startPage";
    }

    @PostMapping("/weatherplus/")
    public String getWeatherPlus(@RequestParam(name = "city") String str, ModelMap modelMap) {
        StringBuilder tempConf = new StringBuilder(url);
        switch (str) {
            case "Seoul" -> {
                tempConf.append("latitude=");
                tempConf.append(37.532600);
                tempConf.append("&longitude=");
                tempConf.append(127.024612);
            }
            case "Suwon" -> {
                tempConf.append("latitude=");
                tempConf.append(37.29111);
                tempConf.append("&longitude=");
                tempConf.append(127.00889);
            }
            case "Jeju" -> {
                tempConf.append("latitude=");
                tempConf.append(33.499621);
                tempConf.append("&longitude=");
                tempConf.append(126.531188);
            }
        }

        tempConf.append("&hourly=temperature_2m&timezone=ROK");

        Weather weather = restTemplate.exchange(tempConf.toString(), HttpMethod.GET, null,
                new ParameterizedTypeReference<Weather>() {
                }).getBody();
        if (weather == null) {
            throw new WeatherError("weather is null");
        }
        Hourly hourly = weather.getHourly();
        modelMap.addAttribute("hourly" ,hourly);
        return "resultPage";
    }

    @PostMapping("/weather/")
    public String getWeather(@ModelAttribute WeatherConf conf, ModelMap modelMap) {

        String tempConf = url + "latitude=" +
                conf.getLatitude() +
                "&longitude=" +
                conf.getLongitude() +
                "&hourly=temperature_2m&timezone=ROK";

        Weather weather = restTemplate.exchange(tempConf, HttpMethod.GET, null,
                new ParameterizedTypeReference<Weather>() {
                }).getBody();

        if (weather == null) {
            throw new WeatherError("weather is null");
        }
        Hourly hourly = weather.getHourly();

        modelMap.addAttribute("hourly" ,hourly);

        return "resultPage";
    }
}
