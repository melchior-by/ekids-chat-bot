package by.ekids.weather.service;

import by.ekids.weather.helpers.TempConverter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherForecast {
    private static final String API_KEY = "6de1d5f20dff0186ae9332cc1ce7ded8";
    private static final String CITY_NAME = "MINSK";

    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather";

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "?q=" + CITY_NAME + "&appid=" + API_KEY))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(WeatherForecast::parse)
                .thenAccept(weatherResponse -> {
                    for (Weather weather : weatherResponse.getWeather()) {
                        System.out.println("Weather: " + weather.getMain() + ", " + weather.getDescription());
                    }
                    System.out.println("Temperature: " + TempConverter.fromKelvinToCelsiusAsString(weatherResponse.getMain().getTemp()));
                    System.out.println("Humidity: " + weatherResponse.getMain().getHumidity());
                })
                .join();
    }

    private static WeatherResponse parse(String responseBody) {
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weatherResponse = null;
        try {
            weatherResponse = mapper.readValue(responseBody, WeatherResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weatherResponse;
    }
}

