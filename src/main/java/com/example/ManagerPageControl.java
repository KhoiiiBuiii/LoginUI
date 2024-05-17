package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import java.util.HashMap;
import java.util.Map;


public class ManagerPageControl {
    @FXML
    private Label welcomeLabel;
    @FXML
    private VBox additionalContentContainer;
    @FXML
    private Button logoutButton;
    @FXML
    private Label servicesLabel;
    @FXML
    private VBox servicesContainer;
    @FXML
    private Button selfInfoButton;
    @FXML
    private Button manageClaimsButton;
    @FXML
    private Button viewSurveyorsButton;
    @FXML
    private TextField searchField;
    @FXML
    private VBox claimsContainer;

    private Map<String, String> claimsData;

    public void initialize() {
        String loggedInUserName = getLoggedInUserName(); // Name method
        if (loggedInUserName != null && !loggedInUserName.isEmpty()) {
            welcomeLabel.setText("Welcome Back, " + loggedInUserName);
        } else {
            // Placeholder because no data
            welcomeLabel.setText("Welcome!");
        }
    }

    // Name fetch logic
    private String getLoggedInUserName() {
        // Placeholder
        return "Manager";
    }

    @FXML
    private void handleLogoutButtonAction(ActionEvent event) {
        try {
            Main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleSelfInfoButton() {
        clearAdditionalContent();

        Label titleLabel = new Label("Self Information");
        additionalContentContainer.getChildren().add(titleLabel);

        HBox buttonsContainer = new HBox(10);
        Button viewButton = new Button("View");
        Button updateButton = new Button("Update");
        buttonsContainer.getChildren().addAll(viewButton, updateButton);
        additionalContentContainer.getChildren().add(buttonsContainer);

        viewButton.setOnAction(event -> showSelfInfo());
        updateButton.setOnAction(event -> enableSelfInfoEditing());
    }
    private void showSelfInfo() {
        clearAdditionalContent();

        // Mock data for user
        String name = "User Name";
        String phone = "123-456-7890";
        String address = "123 Main St, City";
        String email = "user@example.com";
        String password = "password";

        Label nameLabel = new Label("Name: " + name);
        Label phoneLabel = new Label("Phone: " + phone);
        Label addressLabel = new Label("Address: " + address);
        Label emailLabel = new Label("Email: " + email);
        Label passwordLabel = new Label("Password: " + password);

        VBox userInfo = new VBox(5);
        userInfo.getChildren().addAll(nameLabel, phoneLabel, addressLabel, emailLabel, passwordLabel);

        additionalContentContainer.getChildren().add(userInfo);
    }

    private void enableSelfInfoEditing() {
        clearAdditionalContent();

        String name = "User Name";
        String phone = "123-456-7890";
        String address = "123 Main St, City";
        String email = "user@example.com";
        String password = "password";

        // Info to text field
        TextField nameField = new TextField(name);
        TextField phoneField = new TextField(phone);
        TextField addressField = new TextField(address);
        TextField emailField = new TextField(email);
        TextField passwordField = new TextField(password);

        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> saveSelfInfo(nameField.getText(), phoneField.getText(), addressField.getText(), emailField.getText(), passwordField.getText()));

        VBox userInfo = new VBox(5);
        userInfo.getChildren().addAll(
                new Label("Name:"), nameField,
                new Label("Phone:"), phoneField,
                new Label("Address:"), addressField,
                new Label("Email:"), emailField,
                new Label("Password:"), passwordField,
                saveButton
        );

        additionalContentContainer.getChildren().add(userInfo);
    }


    private void saveSelfInfo(String name, String phone, String address, String email, String password) {
        clearAdditionalContent();

        Label nameLabel = new Label("Name: " + name);
        Label phoneLabel = new Label("Phone: " + phone);
        Label addressLabel = new Label("Address: " + address);
        Label emailLabel = new Label("Email: " + email);
        Label passwordLabel = new Label("Password: " + password);

        VBox userInfo = new VBox(5);
        userInfo.getChildren().addAll(nameLabel, phoneLabel, addressLabel, emailLabel, passwordLabel);

        additionalContentContainer.getChildren().add(userInfo);
    }

    private void clearAdditionalContent() {
        additionalContentContainer.getChildren().clear();
    }

}