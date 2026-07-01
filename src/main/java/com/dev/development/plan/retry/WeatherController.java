package com.dev.development.plan.retry;


import java.net.ConnectException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

  private final WeatherClient weatherClient;

  public WeatherController(WeatherClient weatherClient) {
    this.weatherClient = weatherClient;
  }


  @GetMapping("/weather-forecast")
  public String getWeatherForecast() throws ConnectException {
    return weatherClient.getForecast();
  }

  @GetMapping("/weather-forecast-retry")
  public String getWeatherForecastWithRetryTemplate() throws ConnectException {
    return weatherClient.getForecastRetryTemplate();
  }
}
