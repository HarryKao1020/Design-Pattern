package 第二章觀察者模式.Weather_Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{

    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    // 建立觀察者的清單
    public WeatherData(){
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
            observer.update(temperature,humidity,pressure);
        }
    }

    // 確認資料有更新,再去通知觀察者
    public void makesurementsChanged(){
        notifyObserver();
    }
}
