package 第一章策略模式.Payment_Strategy;

public class Client {
    public static void main(String[] args) {

        // ==== BodyShow實作
        Store store = new BodyShopStore();
        store.shopBasicInfo();
        store.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        store.checkout(1000);
        store.setPaymentStrategy(new LinePayPayment("user@example.com"));
        store.checkout(1500);

        // ==== Sabon實作
        Store sabon = new SabonStore();
        sabon.shopBasicInfo();
        sabon.setPaymentStrategy(new LinePayPayment("harry@1234"));
        sabon.checkout(3500);
    }
}
