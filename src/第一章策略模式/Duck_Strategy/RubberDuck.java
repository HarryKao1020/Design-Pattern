package 第一章策略模式.Duck_Strategy;

public class RubberDuck extends Duck{
    public RubberDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squack();
    }

    @Override
    public void display() {
        System.out.println("我是一個橡皮鴨");
    }
}
