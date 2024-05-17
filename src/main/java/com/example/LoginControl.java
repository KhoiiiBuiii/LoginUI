package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginControl {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws Exception {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (isValidCredentials(username, password)) {
            showAlert("Login Successful", "Welcome, " + username + "!");
            // Determine user role and navigate to respective page
            if (username.equals("admin")) {
                Main.showAdminPage();
            } else if (username.equals("policyowner")) {
                Main.showPolicyOwnerPage();
            } else {
                showAlert("Error", "Invalid user role");
            }
        } else {
            showAlert("Login Failed", "Invalid username or password");
        }
    }

    private boolean isValidCredentials(String username, String password) {
        // Add your authentication logic here
        return username.equals("admin") && password.equals("admin123")
                || username.equals("customer") && password.equals("customer123")
                || username.equals("provider") && password.equals("provider123")
                || username.equals("policyowner") && password.equals("owner123");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
