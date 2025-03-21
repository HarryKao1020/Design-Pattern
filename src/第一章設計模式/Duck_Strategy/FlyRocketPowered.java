package 第一章設計模式.Duck_Strategy;

public class FlyRocketPowered implements FlyBehavior{
    @Override
    public void fly(){
        System.out.println("Fly with Rocket ! ");
    }
}
