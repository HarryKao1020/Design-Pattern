package 第一章設計模式.Duck_Strategy;

public class FlyNoWay implements FlyBehavior{

    @Override
    public void fly(){
        System.out.println("I have wings, but I can't fly.");
    }
}
