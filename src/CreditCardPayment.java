import java.time.LocalDateTime;
import java.util.Random;

public class CreditCardPayment extends BasePayment {
    private int cardNumber;
    private String cardHolder;

    public CreditCardPayment(int cardNumber, String cardHolder) {
        paymentMethod = "Credit card";
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
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
        return super.getTransactionDetails() + "\nCard holder: " + cardHolder;
    }
}
