interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(String cardNumber, String cardHolderName, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment...");
        System.out.println("Amount: $" + amount);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Card Holder: " + cardHolderName);
        // Additional logic to process payment via credit card
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment...");
        System.out.println("Amount: $" + amount);
        System.out.println("Email: " + email);
        // Additional logic to process payment via PayPal
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}

// StrategyPatternTest.java
public class StrategyPatternTest {
    public static void main(String[] args) {
        // Create a PaymentContext with CreditCardPayment strategy
        PaymentStrategy creditCardPayment = new CreditCardPayment(
            "1234-5678-9876-5432", "John Doe", "123", "12/25"
        );
        PaymentContext paymentContext = new PaymentContext(creditCardPayment);
        
        // Execute payment using Credit Card
        System.out.println("Using Credit Card Payment Strategy:");
        paymentContext.executePayment(150.00);
        System.out.println();

        // Switch to PayPalPayment strategy
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com", "password123");
        paymentContext.setPaymentStrategy(payPalPayment);
        
        // Execute payment using PayPal
        System.out.println("Using PayPal Payment Strategy:");
        paymentContext.executePayment(200.00);
    }
}
