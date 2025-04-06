package 第二章觀察者模式.Youtube_Observer.Observer;

import 第二章觀察者模式.Youtube_Observer.Subject.Channel;
import 第二章觀察者模式.Youtube_Observer.Subject.YoutubeChannel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class YoutubeUser implements Subscriber{

    private String userName;
    private String email;
    private YoutubeChannel youtubeChannel;
    private List<Channel> subscribeChannelList = new ArrayList<>();


    // 建構子,初始化物件
    public YoutubeUser(String userName,String userEmail){
        this.userName = userName;
        this.email = userEmail;
    }

    // 註冊成觀察者,簡單來說就是我要訂閱某頻道變成訂閱者
    public void subscribe(YoutubeChannel channel){
        channel.registerSubscriber(this);
        // 加入使用者訂閱的清單裡
        subscribeChannelList.add(channel);
        System.out.println(userName + " 訂閱了 " + channel.getChannelName());
    }

    public void unSubscribe(YoutubeChannel channel){
        channel.removeSubscriber(this);
        // 加入使用者訂閱的清單裡
        subscribeChannelList.remove(channel);
        System.out.println(userName + " 取消訂閱 " + channel.getChannelName());
    }


    public String channelName;
    public String latestVideo;
    // 收到訂閱youtuber的更新
    @Override
    public void update(Channel channel) {
        channelName = channel.getChannelName();
        latestVideo = channel.getLatestVideo();
        System.out.println("訊息: " + channelName + " 上傳了新影片:" + latestVideo );
    }

    public void getSubscribeChannelList(){
        System.out.println(userName+"訂閱清單: ");
        for(Channel channel : subscribeChannelList){
            System.out.println(channel.getChannelName());
        }

    }
}
