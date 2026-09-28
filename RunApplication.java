//main method
import java.util.Scanner;

public class RunApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String consoleType = "";
        while (consoleType.isEmpty()) {
            System.out.println("Select the console type");
            System.out.println("1) PS5");
            System.out.println("2) XBOX");
            System.out.println("3) SWITCH");

            String choice = input.nextLine().trim();
            switch (choice) {
                case "1": consoleType = "PS5"; break;
                case "2": consoleType = "XBOX"; break;
                case "3": consoleType = "SWITCH"; break;
                default:
                    System.out.println("Invalid choice, please enter 1, 2 or 3.\n");
            }
        }

        System.out.print("Enter the store: ");
        String store = input.nextLine();

        int totalSales = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter the total sales of " + consoleType
                    + " consoles for " + store + ": ");
            try {
                totalSales = Integer.parseInt(input.nextLine().trim());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }

        ConsoleSales report = new ConsoleSales(consoleType, store, totalSales);
        report.printReport();

        input.close();
    }
}
