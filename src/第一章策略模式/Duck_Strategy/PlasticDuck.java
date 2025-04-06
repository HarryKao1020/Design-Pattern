package 第一章策略模式.Duck_Strategy;

public class PlasticDuck extends Duck{
    public PlasticDuck(){
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("我是塑膠鴨");
    }
}
