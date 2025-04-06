package 第一章策略模式.Payment_Strategy;

public class BodyShopStore extends Store{

    // 建構子
    public BodyShopStore(){
        // 初始支付方法 或 在實作的時候再指定(透過set)
//        paymentBehavior=new LinePayPayment("harryKao1998");
    }

    @Override
    public void shopBasicInfo() {
        System.out.println("This is BodyShop , Welcome to here!");
    }


}
