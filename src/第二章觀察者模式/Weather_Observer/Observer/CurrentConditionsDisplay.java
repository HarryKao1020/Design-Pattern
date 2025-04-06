package 第二章觀察者模式.Weather_Observer.Observer;

import 第二章觀察者模式.Weather_Observer.Subject.WeatherData;



public class CurrentConditionsDisplay implements Observer,DisplayElement{

    // 不顯示pressure
    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    // 建構子,他是一個Observer , 所以他要像Subject註冊成一個Observer
    public CurrentConditionsDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    // 覆寫display , 顯示目前的數據
    @Override
    public void display() {
        System.out.println("Current conditions : "+ temperature + " F degrees and " + humidity+"% humidity");
    }

    // 覆寫update ,原本是接收subject推送過來的新數據,但這樣不好,因為像這個pressure其實currentCondition用不到
//    @Override
//    public void update(float temp, float humidity, float pressure) {
//        this.temperature = temp;
//        this.humidity = humidity;
//        display();
//    }

    // 改成透過observer自己去撈需要的subject資料,一樣是在收到更新的時後
    @Override
    public void update(){
        temperature = weatherData.getTemperature();
        humidity = weatherData.getHumidity();
        display();
    }
}
