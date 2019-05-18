package application.controllers;

import application.model.ExchangeModel;
import application.office.Currency;
import application.office.ExchangeOffice;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ExchangeController {


    private ExchangeModel exchangeModel;
    private ExchangeOffice exchangeOffice;

    @FXML
    Button exchangeButton;

    @FXML
    MenuItem currencyItemPLNFrom;

    @FXML
    MenuItem currencyItemUSDFrom;

    @FXML
    MenuItem currencyItemEURFrom;

    @FXML
    MenuItem currencyItemPLNTo;

    @FXML
    MenuItem currencyItemUSDTo;

    @FXML
    MenuItem currencyItemEURTo;

    @FXML
    MenuButton currencyMenuButtonFrom;

    @FXML
    MenuButton currencyMenuButtonTo;

    @FXML
    TextField valueField;

    @FXML
    TextField exchangeResultField;

    @FXML
    public void initialize() {
        // currencyMenuButtonFrom.getItems().add(new MenuItem("currency"));
        currencyMenuButtonFrom.getItems().forEach(i -> i.setOnAction(e -> {
            System.out.println(i.getText());
            currencyMenuButtonFrom.setText(i.getText());
        }));

        //  currencyMenuButtonTo.getItems().add(new MenuItem("currency"));
        currencyMenuButtonTo.getItems().forEach(i -> i.setOnAction(e -> {
            System.out.println(i.getText());
            currencyMenuButtonTo.setText(i.getText());
        }));

    }

    public void getExchangeParameters() {
        exchangeModel = new ExchangeModel();
        exchangeModel.setCurrencyFrom(Currency.valueOf(currencyMenuButtonFrom.getText()));
        exchangeModel.setCurrencyTo(Currency.valueOf(currencyMenuButtonTo.getText()));
        exchangeModel.setValue(new BigDecimal(valueField.getText()));

        System.out.println(exchangeModel.toString());

        sendParametersToExchangeOffice(exchangeModel);
    }

    public void sendParametersToExchangeOffice(ExchangeModel exchangeModel) {
        exchangeOffice = new ExchangeOffice(1000);
        BigDecimal result = exchangeOffice.exchange(exchangeModel.getValue(), exchangeModel.getCurrencyFrom(), exchangeModel.getCurrencyTo());
        exchangeResultField.setText(showResult(result));
    }


    public String showResult(BigDecimal result) {
        DecimalFormat format = new DecimalFormat("##.00");
        return format.format(result);
    }

}
