package application.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private MenuItem newExchangeItem;

    @FXML
    private MenuItem closeItem;

    @FXML
    public void initialize() {
    }

    @FXML
    public void newExchange() {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/exchange-screen.fxml"));
        try {
            StackPane stackPane = fxmlLoader.load();
            Scene scene = new Scene(stackPane);
            Stage stage = new Stage();
            stage.setTitle("Exchange window");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void close() {
        Platform.exit();
    }

}
