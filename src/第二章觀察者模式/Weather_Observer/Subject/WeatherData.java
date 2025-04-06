package 第二章觀察者模式.Weather_Observer.Subject;

import 第二章觀察者模式.Weather_Observer.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    // 建立觀察者的清單
    public WeatherData(){
        // observers = [Observer , Observer , Observer....]
        observers = new ArrayList<Observer>();

    }

    // 將觀察者放入
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    // 將觀察者移除
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    // 通知觀察者有更新資料,針對介面寫程式
    @Override
    public void notifyObserver() {
        for(Observer observer : observers){
            observer.update();
        }
    }

    // 讓observer可以get最新數據
    public float getHumidity(){
        return humidity;
    }
    public float getTemperature(){
        return temperature;
    }
    public float getPressure(){
        return pressure;
    }

    // 確認從氣象站抓到的資料有更新,再去通知觀察者
    public void makesurementsChanged(){
        notifyObserver();
    }

    // 測試用的,不是用真正的偵測設備的數據 ,因為這是測試案例,沒有設備,所以這邊加這個假裝偵測到的數據
    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        makesurementsChanged();
    }
}
