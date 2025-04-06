package 第二章觀察者模式.Youtube_Observer;

import 第二章觀察者模式.Youtube_Observer.Observer.YoutubeUser;
import 第二章觀察者模式.Youtube_Observer.Subject.YoutubeChannel;

public class YoutubeDemo {
    public static void main(String[] args) {
        YoutubeChannel dodoMenChannel = new YoutubeChannel("The DoDo Men");
        YoutubeChannel andyChannel = new YoutubeChannel("Andy老師");
        YoutubeChannel joemanChannel = new YoutubeChannel("Joeman");

        YoutubeUser harryKaoUser = new YoutubeUser("harry","harrykao@gmail.com");
        YoutubeUser luluChenUser = new YoutubeUser("LuLu","lulu@test.com");

        // 訂閱成為觀察者
        luluChenUser.subscribe(joemanChannel);
        harryKaoUser.subscribe(dodoMenChannel);
        harryKaoUser.subscribe(andyChannel);

        // subject更新資訊,會通知observer去抓最新的影片
        dodoMenChannel.uploadVideo("頻道重大消息公佈！");
        andyChannel.uploadVideo("10年來,我一無所有!");
        joemanChannel.uploadVideo("一戶4億的東區頂級豪宅！台北星鑽");

        harryKaoUser.getSubscribeChannelList();
    }
}
