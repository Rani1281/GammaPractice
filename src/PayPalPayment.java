import java.time.LocalDateTime;
import java.util.Random;

public class PayPalPayment extends BasePayment {
    private String email;

    public PayPalPayment(String email) {
        paymentMethod = "PayPal";
        this.email = email;
    }

    @Override
    public int processPayment(double amount) {
        System.out.println("Processing payment...");
        Random rand = new Random();

        transactionId = rand.nextInt(10000);
        timestamp = LocalDateTime.now();
        super.amount = amount;

        return transactionId;
    }

    @Override
    public String getTransactionDetails() {
        return super.getTransactionDetails() + "\nEmail: " + email;
    }
}
