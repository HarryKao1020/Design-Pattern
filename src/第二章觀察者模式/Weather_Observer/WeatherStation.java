package 第二章觀察者模式.Weather_Observer;

import 第二章觀察者模式.Weather_Observer.Observer.CurrentConditionsDisplay;
import 第二章觀察者模式.Weather_Observer.Observer.ForecastDisplay;
import 第二章觀察者模式.Weather_Observer.Subject.WeatherData;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        weatherData.setMeasurements(80,60,30.4f);
        weatherData.setMeasurements(30,50,60.2f);
        weatherData.setMeasurements(10,50,30);
    }
}
