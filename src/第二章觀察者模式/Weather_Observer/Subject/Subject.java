package 第二章觀察者模式.Weather_Observer.Subject;

import 第二章觀察者模式.Weather_Observer.Observer.Observer;

public interface Subject {
    public void registerObserver(Observer o); // 註冊Observe
    public void removeObserver(Observer o); // 移除Observer
    public void notifyObserver(); // 當Subject的狀態改變時,通知所有Observer
}
