package 第一章策略模式.Duck_Strategy;

public class MuteQuack implements  QuackBehavior{
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
