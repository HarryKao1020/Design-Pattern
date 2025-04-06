package 第一章策略模式.Payment_Strategy;

public abstract class  Store {

    public Store(){};

    public abstract void shopBasicInfo();

    public PaymentBehavior paymentBehavior;


    // 執行支付
    public void checkout(int amount){
        paymentBehavior.pay(amount);
    }
    // 設置支付策略
    public void setPaymentStrategy(PaymentBehavior paymentBehavior){
        this.paymentBehavior = paymentBehavior;
    }


}
