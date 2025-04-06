package 第二章觀察者模式.Youtube_Observer.Subject;

import 第二章觀察者模式.Youtube_Observer.Observer.Subscriber;

public interface Channel {
    public void notifySubscriber();
    public void removeSubscriber(Subscriber s);
    public void registerSubscriber(Subscriber s );

    String getChannelName();
    String getLatestVideo();
}
