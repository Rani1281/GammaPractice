import java.util.InputMismatchException;
import java.util.Scanner;

public class Store {

    public static Scanner scanner = new Scanner(System.in);
    public static PaymentManager manager = new PaymentManager(1000);

    public static void main(String[] args) {

        while (true) {
            // menu
            int mode = showMenu();
            if (mode == 1) {
                // buy something
                buySomething();
            } else if (mode == 2) {
                System.out.println();
                manager.printPayments();
            } else if (mode == 3) {
                double moneyToLoad = loadMoney();
                manager.loadMoney(moneyToLoad);
            } else if (mode == 4) {
                System.out.println("\nCurrent money: " + manager.getMoney() + " ILS");
            } else if (mode == 5) {
                break;
            }

        }

        System.out.println("Exited");
        scanner.close();
    }

    public static int showMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1 | Buy something");
        System.out.println("2 | Show my purchases");
        System.out.println("3 | Load money");
        System.out.println("4 | Show money");
        System.out.println("5 | Exit");

        int choice;
        while (true) {
            try {
                System.out.print("Choice: ");
                choice = scanner.nextInt();
                if (choice > 0 && choice <= 5)
                    return choice;
                else {
                    System.out.println("Invalid choice");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice");
                scanner.nextLine();
            }
        }
    }

    public static void buySomething() {
        System.out.println();
        // choose product
        Product[] products = new Product[3];
        products[0] = new Product("Laptop", 3000, "Lenovo");
        products[1] = new Product("Bread", 15, "Berman");
        products[2] = new Product("T-Shirt", 80, "Renuar");

        int idx = chooseProduct(products);
        Product chosenProduct = products[idx];

        // choose payment method
        BasePayment[] methods = new BasePayment[3];
        methods[0] = new CreditCardPayment(123, "Rani");
        methods[1] = new PayPalPayment("rani@gmail.com");
        methods[2] = new CryptoPayment("cryptoaddress.com");
        System.out.println();

        int methodIdx = choosePaymentMethod(methods);
        BasePayment chosenMethod = methods[methodIdx];

        // pay
        boolean confirm = confirmPay();

        if (confirm) {
            manager.pay(chosenMethod, chosenProduct.getPrice());
        } else {
            System.out.println("Exited");
        }
    }

    public static double loadMoney() {
        System.out.print("\nEnter money to load (up to 1000): ");
        double money;
        while (true) {
            try {
                money = scanner.nextInt();
                if (money > 0 && money <= 1000)
                    return money;
                else {
                    System.out.println("Invalid choice");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice");
                scanner.nextLine();
            }
        }
    }

    public static int chooseProduct(Product[] products) {
        System.out.println("What would you like to buy?");
        for (int i = 0; i < products.length; i++) {
            Product p = products[i];
            System.out.println(i + 1 + " | " + p.getName() + " | " + p.getBrand() + " | " + p.getPrice());
        }

        int choice;
        while (true) {
            try {
                System.out.print("Choice: ");
                choice = scanner.nextInt();
                if (choice > 0 && choice <= products.length)
                    return choice - 1;
                else {
                    System.out.println("Invalid choice");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice");
                scanner.nextLine();
            }
        }
    }

    public static int choosePaymentMethod(BasePayment[] methods) {
        System.out.println("Choose payment method:");
        for (int i = 0; i < methods.length; i++) {
            BasePayment p = methods[i];
            System.out.println(i + 1 + " | " + p.paymentMethod);
        }

        int choice;
        while (true) {
            try {
                System.out.print("Choice: ");
                choice = scanner.nextInt();
                if (choice > 0 && choice <= methods.length)
                    return choice - 1;
                else {
                    System.out.println("Invalid choice");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice");
                scanner.nextLine();
            }
        }
    }

    public static boolean confirmPay() {
        System.out.print("Confirm purchase (Y/N): ");
        String choice;
        while (true) {
            try {
                System.out.print("Choice: ");
                choice = scanner.next();
                if (choice.toUpperCase().equals("Y"))
                    return true;
                else if (choice.toUpperCase().equals("N"))
                    return false;
                else {
                    System.out.println("Invalid choice");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice");
                scanner.nextLine();
            }
        }
    }

}
