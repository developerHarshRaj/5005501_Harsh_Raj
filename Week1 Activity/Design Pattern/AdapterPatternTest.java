interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPal {
    public void makePayment(double amount) {
        System.out.println("Payment of $" + amount + " made using PayPal.");
    }
}

class Stripe {
    public void pay(double amount) {
        System.out.println("Payment of $" + amount + " made using Stripe.");
    }
}

class Square {
    public void processTransaction(double amount) {
        System.out.println("Payment of $" + amount + " made using Square.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.pay(amount);
    }
}

class SquareAdapter implements PaymentProcessor {
    private Square square;

    public SquareAdapter(Square square) {
        this.square = square;
    }

    @Override
    public void processPayment(double amount) {
        square.processTransaction(amount);
    }
}

public class AdapterPatternTest {
    public static void main(String[] args) {
        // Test PayPal payment
        PayPal payPal = new PayPal();
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPal);
        payPalAdapter.processPayment(100.0);

        // Test Stripe payment
        Stripe stripe = new Stripe();
        PaymentProcessor stripeAdapter = new StripeAdapter(stripe);
        stripeAdapter.processPayment(150.0);

        // Test Square payment
        Square square = new Square();
        PaymentProcessor squareAdapter = new SquareAdapter(square);
        squareAdapter.processPayment(200.0);
    }
}
