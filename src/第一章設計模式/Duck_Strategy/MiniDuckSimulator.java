package 第一章設計模式.Duck_Strategy;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performQuack();
        mallard.performFly();

        System.out.println("-------------");

        Duck rubber = new RubberDuck();
        rubber.display();
        rubber.performFly();
        rubber.setFlyBehavior(new FlyRocketPowered());
        rubber.performFly();

        System.out.println("--------------");
    }
}
