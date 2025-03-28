package 第一章策略模式.Duck_Strategy;

public abstract class Duck {
    // 建構子,不初始化,給子類決定具體行為
    public Duck(){

    }

    // 抽象方法,子類必須實作
    public abstract void display();

    // 介面是超型態的一種
    FlyBehavior flyBehavior; // 宣告超型態的引用變數
    QuackBehavior quackBehavior;


    public void performQuack(){
        quackBehavior.quack(); //委派給具體的叫聲行為
    }

    public void performFly(){
        flyBehavior.fly();// 委派給具體的飛行行為
    }

    // 動態變更行為的方法
    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }

    // 動態變更行為的方法
    public void setQuackBehavior(QuackBehavior qb){
        quackBehavior =qb;
    }

    // 所有鴨子都會游泳，所以是共同實作
    public void swim() {
        System.out.println("所有的鴨子都會漂浮，即使是誘餌鴨！");
    }

}



