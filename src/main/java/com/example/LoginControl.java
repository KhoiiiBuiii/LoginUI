package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class LoginControl {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLoginButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            if (authenticate(username, password)) {
                if (isAdmin(username, password)) {
                    showAlert(AlertType.INFORMATION, "Login Successful", "Welcome Admin " + username + "!");
                    Main.showAdminPage();
                } else {
                    showAlert(AlertType.INFORMATION, "Login Successful", "Welcome " + username + "!");
                    Main.showMainPage();
                }
            } else {
                showAlert(AlertType.ERROR, "Login Failed", "Incorrect username or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean authenticate(String username, String password) {
        // Predefined correct username and password for both user and admin
        String correctUserUsername = "user";
        String correctUserPassword = "pass";
        String correctAdminUsername = "admin";
        String correctAdminPassword = "adminpass";

        // Check if the input username and password match either the user or admin credentials
        return (correctUserUsername.equals(username) && correctUserPassword.equals(password)) ||
                (correctAdminUsername.equals(username) && correctAdminPassword.equals(password));
    }

    private boolean isAdmin(String username, String password) {
        // Predefined correct admin username and password
        String correctAdminUsername = "ADMIN";
        String correctAdminPassword = "ADMIN123";

        // Check if the input username and password match the admin credentials
        return correctAdminUsername.equals(username) && correctAdminPassword.equals(password);
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
