package 第一章策略模式.Payment_Strategy;

public class Client {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        shoppingCart.checkout(1000);

        shoppingCart.setPaymentStrategy(new LinePayPayment("user@example.com"));
        shoppingCart.checkout(1500);
    }
}
