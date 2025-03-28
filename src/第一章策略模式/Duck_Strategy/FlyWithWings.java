package 第一章策略模式.Duck_Strategy;

public class FlyWithWings implements FlyBehavior{

    @Override
    public void fly(){
        System.out.println("I'm flying with wings !");
    }
}
