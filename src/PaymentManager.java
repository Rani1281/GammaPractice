import java.util.HashMap;
import java.util.Map;

public class PaymentManager {

    private HashMap<Integer, BasePayment> allPayments;
    private double money; // money in all payment methods

    public double getMoney() {
        return this.money;
    }

    public void loadMoney(double amount) {
        money += amount;
    }

    public PaymentManager(double initialMoney) {
        this.allPayments = new HashMap<>();
        this.money = initialMoney;
    }

    public void pay(BasePayment basePayment, double amount) {
        if (money < amount) {
            System.out.println("You don't have enough money!");
            return;
        }

        int transactionId = basePayment.processPayment(amount);
        // increment the id until the same id isn't found
        while (allPayments.containsKey(transactionId)) {
            transactionId++;
        }
        basePayment.updateId(transactionId);

        money -= amount;
        allPayments.put(transactionId, basePayment);
        System.out.println("Payment successful!\nMoney remaining: " + money);
    }

    public void printPayments() {
        System.out.println("All payments:\n");

        for (Map.Entry<Integer, BasePayment> entry : allPayments.entrySet()) {
            System.out.println(entry.getValue().getTransactionDetails() + "\n");
        }
    }

}
