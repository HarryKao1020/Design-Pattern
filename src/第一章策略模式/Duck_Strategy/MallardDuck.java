package 第一章策略模式.Duck_Strategy;

public class MallardDuck extends Duck{
    public MallardDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("我是一隻綠頭鴨");
    }


}
