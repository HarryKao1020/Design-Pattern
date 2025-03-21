package 第一章設計模式.Duck_Strategy;

public class Squack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Squack! Squack!");
    }
}
