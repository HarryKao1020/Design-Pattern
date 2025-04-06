package 第二章觀察者模式.Youtube_Observer.Observer;

import 第二章觀察者模式.Youtube_Observer.Subject.Channel;

public interface Subscriber {
    void update(Channel channel);  // 當創作者上傳新影片時收到通知
}
