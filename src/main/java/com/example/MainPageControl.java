package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MainPageControl {

    @FXML
    private void showDashboard() {
        showAlert(AlertType.INFORMATION, "Dashboard", "Showing the dashboard.");
    }

    @FXML
    private void viewPolicies() {
        showAlert(AlertType.INFORMATION, "Policies", "Viewing policies.");
    }

    @FXML
    private void newPolicy() {
        showAlert(AlertType.INFORMATION, "New Policy", "Creating a new policy.");
    }

    @FXML
    private void fileClaim() {
        showAlert(AlertType.INFORMATION, "File a Claim", "Filing a claim.");
    }

    @FXML
    private void viewClaims() {
        showAlert(AlertType.INFORMATION, "View Claims", "Viewing claims.");
    }

    @FXML
    private void contactSupport() {
        showAlert(AlertType.INFORMATION, "Support", "Contacting support.");
    }

    @FXML
    private void aboutUs() {
        showAlert(AlertType.INFORMATION, "About Us", "About the company.");
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
