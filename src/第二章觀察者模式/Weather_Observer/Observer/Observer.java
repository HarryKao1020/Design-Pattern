package 第二章觀察者模式.Weather_Observer.Observer;

public interface Observer {
    // 原本update這邊會接收到subject傳送近來所有新的數據
    // 路徑是: subject 推送--> observer , 缺點:observer不一定需要所有新的數據
    // public void update(float temp , float humidity,float pressure); // 當Observer收到Subject的通知,更新資料

    // observer只會收到subject的有新數據的通知,但不傳送新數據
    // 而是讓observer都到有新數據的通知時,再去get需要的數據
    public void update();

}
