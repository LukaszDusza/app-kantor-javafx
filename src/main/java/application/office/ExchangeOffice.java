package application.office;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ExchangeOffice{

    private Map<Currency, BigDecimal> availableFunds;

    public ExchangeOffice(double startFunds) {
        this.availableFunds = new HashMap<>();
        for (Currency c : Currency.values()) {
            this.availableFunds.put(c, new BigDecimal(startFunds));
        }
    }

    public void showFunds() {
        System.out.print("Current funds: ");

        for(Map.Entry<Currency, BigDecimal> entry: availableFunds.entrySet()) {
            System.out.print(entry.getValue() + " " + entry.getKey().getName() + "   ");
        }
        System.out.println();
    }

    public BigDecimal exchange(BigDecimal amount, Currency from, Currency to) {
        BigDecimal available = availableFunds.get(to);
        BigDecimal needed = amount.multiply(new BigDecimal(0.8)).multiply(CurrencyConverter.conver(from, to));

        if(available.intValue() >= needed.intValue()) {
            availableFunds.put(from, availableFunds.get(from).add(amount));
            availableFunds.put(to, availableFunds.get(to).subtract(needed));
            System.out.println("Exchanging "
                    + amount
                    + " "
                    + from.getName()
                    + " to " + needed + " " + to.getName());
        } else {
            System.out.println("Cannot exchange " +  amount
                    + " "
                    + from.getName()
                    + " to " + needed + " " + to.getName() + " insufficient funds!");
        }

        return needed;
    }


}
