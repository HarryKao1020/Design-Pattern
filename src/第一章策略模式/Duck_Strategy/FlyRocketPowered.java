package 第一章策略模式.Duck_Strategy;

public class FlyRocketPowered implements FlyBehavior{
    @Override
    public void fly(){
        System.out.println("Fly with Rocket ! ");
    }
}
