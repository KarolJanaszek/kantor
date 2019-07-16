import java.util.HashMap;
import java.util.Map;

public class ExchangeOffice {

    //Mama z kluczami jako waluta, vartościami ile jej mamy
    private Map<Currency, Double> availableFunds = new HashMap<>();

    // ile na początku mamy waluty
    public ExchangeOffice(double startsWith) {
        for (Currency currency : Currency.values()) {
            availableFunds.put(currency, startsWith);
        }
    }

    public void showFounds() {
        for (Currency currency : availableFunds.keySet()) {
            Double value = availableFunds.get(currency);
            System.out.print(String.format("%.2f",value) + " " + currency.getName() + " ; ");
        }
        System.out.println();
    }

    public void exchange(double amount, Currency from, Currency to) {

        double available = availableFunds.get(to);
        double needed = CurrencyConverter.convert(from, to) * amount * 0.8;
        if (available < needed)
            System.out.println("Can not exchange");
        else {
            availableFunds.put(from, availableFunds.get(from) + amount);
            availableFunds.put(to, availableFunds.get(to) - needed);
        }

    }

    public static void main(String[] args) {
        ExchangeOffice exchangeOffice = new ExchangeOffice(1000);
        exchangeOffice.showFounds();
        exchangeOffice.exchange(5000,Currency.PLN,Currency.EUR);
        exchangeOffice.showFounds();
    }
}
