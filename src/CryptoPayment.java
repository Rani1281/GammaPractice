import java.time.LocalDateTime;
import java.util.Random;

public class CryptoPayment extends BasePayment {
    private String walletAddress;

    public CryptoPayment(String walletAddress) {
        paymentMethod = "Crypto";
        this.walletAddress = walletAddress;
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
}
