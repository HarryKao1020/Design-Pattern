package 第一章策略模式.Payment_Strategy;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // 設置支付策略
    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    // 執行支付
    public void checkout(int amount){
        paymentStrategy.pay(amount);
    }
}
