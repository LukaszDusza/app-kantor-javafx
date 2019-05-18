package application.model;

import application.office.Currency;

import java.math.BigDecimal;

public class ExchangeModel {

    private Currency currencyFrom;
    private Currency currencyTo;
    private BigDecimal value;


    public Currency getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(Currency currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public Currency getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(Currency currencyTo) {
        this.currencyTo = currencyTo;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ExchangeModel{" +
                "currencyFrom=" + currencyFrom +
                ", currencyTo=" + currencyTo +
                ", value=" + value +
                '}';
    }
}
