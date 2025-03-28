package 第一章策略模式.Payment_Strategy;

public class CreditCardPayment implements PaymentStrategy{

    private String cardNumber;


    public CreditCardPayment(String cardNumber){
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("使用信卡用支付 "+ amount +"元"+"卡號: "+cardNumber);
    }
}
