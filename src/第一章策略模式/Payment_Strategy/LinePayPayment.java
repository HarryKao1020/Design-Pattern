package 第一章策略模式.Payment_Strategy;

public class LinePayPayment implements PaymentStrategy{
    private String accountId;

    public LinePayPayment(String accountId){
        this.accountId=accountId;
    }
    @Override
    public void pay(int amount) {
        System.out.println("使用LinePay支付 " + amount + " 元，帳號: " + accountId);
    }
}
