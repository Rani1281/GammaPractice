import java.time.LocalDateTime;

abstract class BasePayment implements PaymentMethod {
    protected String paymentMethod;
    protected int transactionId;
    protected LocalDateTime timestamp;
    protected double amount;

    public void updateId(int newId) {
        transactionId = newId;
    }

    @Override
    public String getTransactionDetails() {
        return "Payment method: " + paymentMethod + "\nTransaction id: " + transactionId + "\nTimestamp: " + timestamp
                + "\nAmount: " + amount;
    }

}
