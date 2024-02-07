package com.jfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class primaryController {

  
    @FXML
    private TextArea display;

    @FXML
    private void insert(ActionEvent event) {
        Button bt = (Button) event.getSource();
        if (bt.getText().equals("=")) {
            if (display.getText().matches(".*[-+*/].*")){
                showCalculation();
            }
        } else {
            display.appendText(bt.getText());
        }
    }

    @FXML
    private void clear() {
        display.clear();
    }

    @FXML
    private void backspace() {
        String text = display.getText();
        if (text.length() > 0) {
            display.setText(text.substring(0, text.length() - 1));
        }
    }

    private void showCalculation() {
        String expression = display.getText();
        double result = Calculator.calculate(expression);
        display.setText(String.valueOf(result));
    }
}
