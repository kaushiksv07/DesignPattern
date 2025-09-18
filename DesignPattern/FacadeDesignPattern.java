Facade Design Pattern
The Facade Design Pattern is a structural pattern that provides a simplified (unified) interface to a set of complex subsystems.

// Subsystem 1 - Card Validation
class CardValidator {
    public boolean validate(String cardNumber, String cvv, String expiry) {
        System.out.println("Validating card details...");
        return cardNumber.startsWith("4"); // example: VISA starts with 4
    }
}

// Subsystem 2 - Fraud Check
class FraudChecker {
    public boolean checkFraud(String cardNumber, double amount) {
        System.out.println("Running fraud checks...");
        return amount < 10000; // if amount is too high, mark as fraud
    }
}

// Subsystem 3 - Currency Conversion
class CurrencyConverter {
    public double convert(double amount, String fromCurrency, String toCurrency) {
        System.out.println("Converting currency from " + fromCurrency + " to " + toCurrency);
        if (!fromCurrency.equals(toCurrency)) {
            return amount * 80; // example: USD -> INR conversion
        }
        return amount;
    }
}

// Subsystem 4 - Bank API
class BankAPI {
    public boolean transfer(String cardNumber, double amount) {
        System.out.println("Processing payment of " + amount + " through Bank API...");
        return true;
    }
}

// ----- Facade -----
class PaymentGatewayFacade {
    private CardValidator validator = new CardValidator();
    private FraudChecker fraudChecker = new FraudChecker();
    private CurrencyConverter converter = new CurrencyConverter();
    private BankAPI bankAPI = new BankAPI();

    public void makePayment(String cardNumber, String cvv, String expiry,
                            double amount, String fromCurrency, String toCurrency) {
        System.out.println("----- Payment Process Started -----");

        if (!validator.validate(cardNumber, cvv, expiry)) {
            System.out.println("Payment Failed: Invalid Card Details.");
            return;
        }

        if (!fraudChecker.checkFraud(cardNumber, amount)) {
            System.out.println("Payment Failed: Fraud Detected.");
            return;
        }

        double convertedAmount = converter.convert(amount, fromCurrency, toCurrency);
        boolean success = bankAPI.transfer(cardNumber, convertedAmount);

        if (success) {
            System.out.println("Payment Successful! Amount Debited: " + convertedAmount + " " + toCurrency);
        } else {
            System.out.println("Payment Failed: Bank Declined Transaction.");
        }

        System.out.println("----- Payment Process Ended -----");
    }
}

// ----- Client -----
public class PaymentGatewayDemo {
    public static void main(String[] args) {
        PaymentGatewayFacade gateway = new PaymentGatewayFacade();

        // Client only interacts with Facade, not subsystems
        gateway.makePayment("4123456789012345", "123", "12/26", 
                            120.5, "USD", "INR");

        System.out.println();

        gateway.makePayment("5123456789012345", "456", "11/25", 
                            500.0, "INR", "INR");
    }
}
