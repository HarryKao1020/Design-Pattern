package 第二章觀察者模式.Weather_Observer.Observer;

import 第二章觀察者模式.Weather_Observer.Subject.WeatherData;

public class ForecastDisplay implements DisplayElement,Observer{
    private float currentTemperature = 30;
    private float lastTemperature;
    private String message;
    private WeatherData forecastWeatherData;
    public ForecastDisplay(WeatherData weatherData){
        this.forecastWeatherData = weatherData; // 把外部傳進來的參數weatherData 賦值給forecastWeatherData;
        weatherData.registerObserver(this); // 註冊成observer
    }

    @Override
    public void update() {
        lastTemperature = currentTemperature;
        currentTemperature = forecastWeatherData.getTemperature();
        if(currentTemperature >= 30){
            message = "It's very hot day !";
        }else if (currentTemperature>=20){
            message ="It's very warm day !";
        }else{
            message ="It'a very cold day !";
        }
        display();
    }

    @Override
    public void display() {
        System.out.println("Forecast conditions:" + message );
    }


}
