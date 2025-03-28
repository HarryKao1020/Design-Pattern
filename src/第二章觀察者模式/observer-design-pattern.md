# 觀察者模式(Observer)
觀察者模式是一個非常重要的設計模式，它定義了一種一對多的依賴關係，當一個物件狀態改變時，所有依賴它的物件都會被通知並自動更新。讓我詳細解釋 Subject（主題）和 Observer（觀察者）的概念。

## 觀察者模式的核心概念

### Subject（主題）
- **定義**：Subject是被觀察的對象，它維護了一個觀察者列表，並提供添加、刪除和通知觀察者的方法。
- **職責**：
    1. 管理觀察者列表（註冊和移除觀察者）
    2. 當自身狀態變化時，通知所有註冊的觀察者

### Observer（觀察者）
- **定義**：Observer是接收通知並做出反應的對象。
- **職責**：
    1. 提供一個更新方法，用於接收來自Subject的通知
    2. 根據接收到的通知執行相應的操作

## 觀察者模式的工作流程

1. Subject維護一組Observer對象的引用
2. 當Subject的狀態發生變化時，它會通知所有已註冊的Observer
3. 每個Observer收到通知後，可以查詢Subject以獲取更新的狀態，然後採取適當的行動

## 實際範例

以下是一個簡單的氣象站範例，展示了觀察者模式的實現：

### 接口定義

```java
// 主題接口
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}

// 觀察者接口
public interface Observer {
    public void update(float temp, float humidity, float pressure);
}

// 顯示元素接口
public interface DisplayElement {
    public void display();
}
```

### 主題實現

```java
import java.util.ArrayList;

public class WeatherData implements Subject {
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    
    public WeatherData() {
        observers = new ArrayList<Observer>();
    }
    
    public void registerObserver(Observer o) {
        observers.add(o);
    }
    
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }
    
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
    
    public void measurementsChanged() {
        notifyObservers();
    }
    
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
    
    // 其他方法
}
```

### 觀察者實現

```java
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;
    
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
    
    public void display() {
        System.out.println("當前狀況：溫度 " + temperature + "°C，濕度 " + humidity + "%");
    }
}
```

### 使用觀察者模式

```java
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        
        CurrentConditionsDisplay currentDisplay = 
            new CurrentConditionsDisplay(weatherData);
        
        // 可以添加更多觀察者
        // StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        // ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        
        // 模擬天氣變化
        weatherData.setMeasurements(27, 65, 1013.1f);
        weatherData.setMeasurements(28, 70, 1010.2f);
        weatherData.setMeasurements(26, 80, 1012.5f);
    }
}
```

## 觀察者模式的優點

1. **鬆耦合**：Subject和Observer之間是鬆耦合的關係，Subject不需要知道具體的Observer類別，只需要知道它們實現了Observer接口。
2. **支持廣播通訊**：一個Subject的狀態變化可以通知多個Observer。
3. **開閉原則**：可以添加新的Observer而無需修改Subject的代碼。

## 觀察者模式的應用場景

1. **GUI系統**：當用戶操作一個控件時，需要更新多個相關的控件。
2. **事件處理系統**：當一個事件發生時，多個處理器需要響應。
3. **訂閱-發布系統**：例如RSS訂閱，當有新內容時，所有訂閱者都會收到通知。
4. **MVC架構**：Model作為Subject，View作為Observer，當Model改變時，所有相關的View都會更新。

觀察者模式是一種非常實用的設計模式，尤其適用於對象之間存在一對多依賴關係的場景。透過使用觀察者模式，可以實現對象之間的鬆耦合，同時保持高度的靈活性和可擴展性。

### Youtube範例
https://medium.com/enjoy-life-enjoy-coding/design-pattern-%E5%8F%AA%E8%A6%81%E4%BD%A0%E6%83%B3%E7%9F%A5%E9%81%93-%E6%88%91%E5%B0%B1%E5%91%8A%E8%A8%B4%E4%BD%A0-%E8%A7%80%E5%AF%9F%E8%80%85%E6%A8%A1%E5%BC%8F-observer-pattern-feat-typescript-8c15dcb21622