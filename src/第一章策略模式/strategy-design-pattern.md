# Strtegy設計模式

### 超型態(superType) & 次型態(subType)
超型態 (supertype) 是物件導向程式設計中的一個重要概念。它指的是在繼承層次結構中位於上層的類別或介面，也就是父類別或某個實作的介面。在設計模式和 Java 程式設計中，這個概念尤為重要。
在物件導向程式設計中，超型態的核心優勢是可以讓程式碼更有彈性並實現多型性：

**超型態和次型態關係**：  
- 超型態是父類別或介面
- 次型態 (subtype) 是繼承自父類別或實作介面的類別

**多型性的基礎**：
- 透過宣告超型態的變數，可以引用任何它的次型態物件

**這種設計很符合「寫程式是針對介面寫，而不是針對實踐方式寫」的設計守則，介面（interface）也是超型態（supertype）的一種形式。在Java語言和物件導向設計中，超型態可以是以下兩種形式**：
- 類別超型態（Class Supertype）：通過繼承關係形成的父類別（包括抽象類別)  
- 介面超型態（Interface Supertype）：透過實作關係形成的介面
```java
public interface FlyBehavior {
    public void fly();
}

public class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("I'm flying!!");
    }
}
```
在這個關係中，FlyBehavior是超型態，而FlyWithWings是次型態（subtype）。
使用介面作為超型態在設計模式中非常常見，尤其是在策略模式、工廠模式、觀察者模式等許多模式中。這種做法有以下好處：

更強的抽象：介面比抽象類別提供更高層次的抽象，只定義「做什麼」而不涉及「怎麼做」
更大的彈性：Java不支援多重繼承，但允許實作多個介面
更低的耦合度：代碼依賴介面而非具體實作，使系統更容易維護和擴展

設計守則中的「面向介面編程而非實作」（Program to interfaces, not implementations）就是鼓勵我們使用介面超型態來設計系統。
例如，當你寫：
```java
FlyBehavior flyBehavior = new FlyWithWings();
```
你就在使用介面超型態的引用指向具體實作的物件，這就是多型性（polymorphism）的應用，也是良好物件導向設計的基礎。

## 以Duck為例子
- Duck有 Fly跟Quack兩種行為
- 有不同品種的Duck,分別有不同的Fly跟Quack

```java
// 飛行行為介面（超型態）
public interface FlyBehavior {
    public void fly();
}

// 具體飛行行為實作（次型態）
public class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("我正在飛翔！");
    }
}

public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("我不會飛！");
    }
}

public class FlyRocketPowered implements FlyBehavior {
    public void fly() {
        System.out.println("我用火箭動力飛行！轟隆隆！");
    }
}

// 叫聲行為介面（超型態）
public interface QuackBehavior {
    public void quack();
}

// 具體叫聲行為實作（次型態）
public class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("呱呱呱！");
    }
}

public class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("<< 沉默... >>");
    }
}

public class Squeak implements QuackBehavior {
    public void quack() {
        System.out.println("吱吱吱！");
    }
}

// Duck 抽象類別（超型態）
public abstract class Duck {
    // 行為變數宣告為介面類型（超型態）
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    
    public Duck() {
        // 建構子不做初始化，由子類別決定具體行為
    }
    
    // 抽象方法，由子類別實作
    public abstract void display();
    
    // 委派給行為類別
    public void performFly() {
        flyBehavior.fly(); // 委派給具體的飛行行為
    }
    
    public void performQuack() {
        quackBehavior.quack(); // 委派給具體的叫聲行為
    }
    
    // 動態設定行為
    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }
    
    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }
    
    // 所有鴨子都會游泳，所以是共同實作
    public void swim() {
        System.out.println("所有的鴨子都會漂浮，即使是誘餌鴨！");
    }
}

// 具體的鴨子實作（次型態）
public class MallardDuck extends Duck {
    public MallardDuck() {
        // 在建構子中設定初始行為
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }
    
    public void display() {
        System.out.println("我是一隻真正的綠頭鴨");
    }
}

public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay(); // 一開始不會飛
        quackBehavior = new Quack();
    }
    
    public void display() {
        System.out.println("我是一個模型鴨");
    }
}

public class RubberDuck extends Duck {
    public RubberDuck() {
        flyBehavior = new FlyNoWay(); // 橡皮鴨不會飛
        quackBehavior = new Squeak(); // 橡皮鴨是吱吱叫
    }
    
    public void display() {
        System.out.println("我是一個橡皮鴨");
    }
}

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        flyBehavior = new FlyNoWay(); // 誘餌鴨不會飛
        quackBehavior = new MuteQuack(); // 誘餌鴨不會叫
    }
    
    public void display() {
        System.out.println("我是一個誘餌鴨");
    }
}

// 測試程式
public class MiniDuckSimulator {
    public static void main(String[] args) {
        // 測試綠頭鴨
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performQuack();
        mallard.performFly();
        
        System.out.println("----------");
        
        // 測試模型鴨 - 展示動態改變行為
        Duck model = new ModelDuck();
        model.display();
        model.performFly(); // 一開始不會飛
        model.setFlyBehavior(new FlyRocketPowered()); // 動態改變行為
        model.performFly(); // 現在用火箭飛
        
        System.out.println("----------");
        
        // 測試橡皮鴨
        Duck rubber = new RubberDuck();
        rubber.display();
        rubber.performQuack();
        rubber.performFly();
        
        System.out.println("----------");
        
        // 測試誘餌鴨
        Duck decoy = new DecoyDuck();
        decoy.display();
        decoy.performQuack();
        decoy.performFly();
    }
}
```
#### 這個設計的優點：

1. 鬆散耦合：Duck 類別與具體的飛行和叫聲行為解耦
2. 易於擴展：可以輕鬆新增不同的飛行或叫聲行為，而不需修改現有的 Duck 類別
3. 行為可重用：不同的鴨子類型可以共享相同的行為類別
4. 運行時彈性：可以在運行時動態改變鴨子的行為  

這種設計模式（策略模式）廣泛應用於實際系統中，它允許我們將變化的部分（飛行和叫聲行為）封裝起來，並與不變的部分（Duck 類別的基本結構）分離。
