package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AdminPageControl {

    @FXML
    private void handleViewRecords() {
        showAlert(AlertType.INFORMATION, "View Records", "This will display the records.");
    }

    @FXML
    private void handleUpdateRecords() {
        showAlert(AlertType.INFORMATION, "Update Records", "This will update the records.");
    }

    @FXML
    private void handleRecordHistory() {
        showAlert(AlertType.INFORMATION, "Record History", "This will record the history.");
    }

    @FXML
    private void handleCrudOperations() {
        showAlert(AlertType.INFORMATION, "CRUD Operations", "This will perform CRUD operations.");
    }

    @FXML
    private void handleCalculateClaimedSum() {
        showAlert(AlertType.INFORMATION, "Calculate Claimed Sum", "This will calculate the claimed sum.");
    }

    @FXML
    private void handleLogout() {
        try {
            Main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
