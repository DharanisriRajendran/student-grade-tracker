
import java.util.*;

class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] stocks = {"TCS", "INFOSYS", "WIPRO"};
        double[] prices = {3500, 1500, 500};

        int[] quantity = {0, 0, 0};

        double balance = 100000;

        int choice;

        do {
            System.out.println("\n===== STOCK TRADING PLATFORM =====");
            System.out.println("1. View Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Stocks:");
                    for (int i = 0; i < stocks.length; i++) {
                        System.out.println(stocks[i] +
                                " - Rs." + prices[i]);
                    }
                    break;

                case 2:
                    System.out.println("\nEnter stock number:");
                    for (int i = 0; i < stocks.length; i++) {
                        System.out.println((i + 1) + ". " + stocks[i]);
                    }

                    int buy = sc.nextInt() - 1;

                    if (buy < 0 || buy >= stocks.length) {
                        System.out.println("Invalid stock!");
                        break;
                    }

                    System.out.print("Enter quantity: ");
                    int buyQty = sc.nextInt();

                    if (buyQty <= 0) {
                        System.out.println("Invalid quantity!");
                        break;
                    }

                    double cost = prices[buy] * buyQty;

                    if (cost <= balance) {
                        balance -= cost;
                        quantity[buy] += buyQty;

                        System.out.println("Stock purchased successfully!");
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                    break;

                case 3:
                    System.out.print("Enter stock number to sell (1-3): ");
                    int sell = sc.nextInt() - 1;

                    if (sell < 0 || sell >= stocks.length) {
                        System.out.println("Invalid stock!");
                        break;
                    }

                    System.out.print("Enter quantity: ");
                    int sellQty = sc.nextInt();

                    if (sellQty <= 0) {
                        System.out.println("Invalid quantity!");
                    } else if (sellQty <= quantity[sell]) {

                        quantity[sell] -= sellQty;
                        balance += prices[sell] * sellQty;

                        System.out.println("Stock sold successfully!");

                    } else {
                        System.out.println("Not enough stocks!");
                    }
                    break;

                case 4:
                    System.out.println("\n===== MY PORTFOLIO =====");

                    System.out.println("Available Balance: Rs." + balance);

                    for (int i = 0; i < stocks.length; i++) {
                        System.out.println(stocks[i] +
                                " Quantity: " + quantity[i]);
                    }
                    break;

                case 5:
                    System.out.println("Thank you for trading!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
