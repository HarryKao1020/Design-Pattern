package 第二章觀察者模式.Youtube_Observer.Subject;

import 第二章觀察者模式.Youtube_Observer.Observer.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Channel{

    private String latestVideo; // 最新的影片
    private String channelName; // 頻道名稱

    // 建構子,初始化頻道名稱
    public YoutubeChannel(String channelName){
        this.channelName = channelName;
    }

    // 訂閱此頻道的清單
    List<Subscriber> subscribers = new ArrayList<>();


    // 移除訂閱者
    @Override
    public void removeSubscriber(Subscriber s) {
        subscribers.remove(s);
    }

    // 有新的訂閱者
    @Override
    public void registerSubscriber(Subscriber s) {
        subscribers.add(s);
    }

    // 通知有新影片
    @Override
    public void notifySubscriber() {
        for(Subscriber subscriber : subscribers){
            subscriber.update(this);
        }
    }

    // 上傳新影片時
    public void uploadVideo(String videoTitle) {
        this.latestVideo = videoTitle;
        System.out.println("\n" + channelName + " 上傳了新影片: " + videoTitle);
        // 通知subscriber有新影片
        notifySubscriber();
    }

    // 提供觀察者可以取得某些值
    @Override
    public String getChannelName() {
        return channelName;
    }

    @Override
    public String getLatestVideo() {
        return latestVideo;
    }


}
