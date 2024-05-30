import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Currency Selection
        System.out.println("Select the base currency:");
        String baseCurrency = scanner.nextLine();

        System.out.println("Select the target currency:");
        String targetCurrency = scanner.nextLine();

        // Step 2: Currency Rates (Hardcoded for simplicity)
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        // Step 3: Amount Input
        System.out.println("Enter the amount to convert:");
        double amountToConvert = scanner.nextDouble();

        // Step 4: Currency Conversion
        double convertedAmount = amountToConvert * exchangeRate;
        scanner.close();

        // Step 5: Display Result
        System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
    }
    

    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        // Hardcoded exchange rates (for simplicity)
        /* In a real-world scenario, you would fetch these rates from an API, So as an intern i try to keep
        it simple since i'm not using API for the rate fetching.
        */
        if (baseCurrency.equals("USD") && targetCurrency.equals("EUR")) {
            return 0.85;
        } else if (baseCurrency.equals("USD") && targetCurrency.equals("GBP")) {
            return 0.75;
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("USD")) {
            return 1.18;
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("GBP")) {
            return 0.88;
        } else if (baseCurrency.equals("GBP") && targetCurrency.equals("USD")) {
            return 1.33;
        } else if (baseCurrency.equals("GBP") && targetCurrency.equals("EUR")) {
            return 1.14;
        } else {
            System.out.println("Unsupported currency pair. Assuming 1:1 exchange rate.");
            return 1.0;
        }
    }
}
