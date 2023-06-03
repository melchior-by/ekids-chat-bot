package by.ekids.weather.helpers;

public class TempConverter {
    public static double fromKelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static String fromKelvinToCelsiusAsString(double kelvin) {
        return String.format("%.2f C", fromKelvinToCelsius(kelvin));
    }
}
