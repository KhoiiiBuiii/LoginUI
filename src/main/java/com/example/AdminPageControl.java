package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;


public class AdminPageControl {
    @FXML
    private Label welcomeLabel;
    @FXML
    private VBox additionalContentContainer;
    @FXML
    private Button logoutButton;
    @FXML
    private Button selfInfoButton;
    @FXML
    private Button viewClaimsButton;
    @FXML
    private Button manageCustomerButton;
    @FXML
    private Button calculateClaimedSumButton;

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
        return "Admin";
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        try {
            Main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void handleSelfInformation() {
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

    public void handleViewClaims() {
        clearAdditionalContent();

        Label titleLabel = new Label("View Claims");
        additionalContentContainer.getChildren().add(titleLabel);

        HBox buttonsContainer = new HBox(10);

        Button viewButton = new Button("View");


        viewButton.setOnAction(event -> viewClaims());

        buttonsContainer.getChildren().addAll( viewButton );
        additionalContentContainer.getChildren().add(buttonsContainer);
    }


    private void viewClaims() {
        clearAdditionalContent();

        // Mock data for multiple claims
        String[] claims = {"Claim 1", "Claim 2", "Claim 3"};
        VBox claimsList = new VBox(5);
        for (String claim : claims) {
            Hyperlink claimLink = new Hyperlink(claim);
            claimLink.setOnAction(event -> showClaimDetails(claim));
            claimsList.getChildren().add(claimLink);
        }

        additionalContentContainer.getChildren().add(claimsList);
    }

    private void showClaimDetails(String claim) {
        // Clear previous additional content
        clearAdditionalContent();

        Label titleLabel = new Label("Claim Details: " + claim);
        additionalContentContainer.getChildren().add(titleLabel);

        // Mock data for claim details
        String claimDate = "2024-05-20";
        String insuredPerson = "John Doe";
        String cardNumber = "1234 5678 9012 3456";
        String examDate = "2024-05-25";
        String documents = "Document 1, Document 2";
        String claimAmount = "$1000";
        String receiverBankingInfo = "Bank Name: ABC Bank, Account Number: 1234567890";

        VBox claimDetails = new VBox(5);
        claimDetails.getChildren().addAll(
                new Label("Claim Date: " + claimDate),
                new Label("Insured Person: " + insuredPerson),
                new Label("Card Number: " + cardNumber),
                new Label("Exam Date: " + examDate),
                new Label("Documents: " + documents),
                new Label("Claim Amount: " + claimAmount),
                new Label("Receiver Banking Info: " + receiverBankingInfo)
        );
        additionalContentContainer.getChildren().addAll(claimDetails );
    }


    public void handleManagedCustomer() {
        clearAdditionalContent();

        Label titleLabel = new Label("Manage Customer");
        additionalContentContainer.getChildren().add(titleLabel);

        // Mock dependant list
        String[] dependants = {"Customer 1", "Customer 2", "Customer 3"};
        VBox dependantsList = new VBox(5);
        for (String customer : dependants) {
            Hyperlink dependantLink = new Hyperlink(customer);
            dependantLink.setOnAction(event -> showDependantOptions(customer));
            dependantsList.getChildren().add(dependantLink);
        }
        additionalContentContainer.getChildren().add(dependantsList);
    }

    private void showDependantOptions(String dependant) {
        clearAdditionalContent();

        Label titleLabel = new Label("Customer Details: " + dependant);
        additionalContentContainer.getChildren().add(titleLabel);

        // Mock data for dependant
        String phone = "123-456-7890";
        String address = "123 Main St, City";
        String email = "dependant@example.com";
        String password = "password";

        Label phoneLabel = new Label("Phone: " + phone);
        Label addressLabel = new Label("Address: " + address);
        Label emailLabel = new Label("Email: " + email);
        Label passwordLabel = new Label("Password: " + password);

        VBox customerDetails = new VBox(5);
        customerDetails.getChildren().addAll(phoneLabel, addressLabel, emailLabel, passwordLabel);

        Button updateButton = new Button("Update");
        updateButton.setOnAction(event -> enableDependantEditing(customerDetails, phone, address, email, password));

        additionalContentContainer.getChildren().addAll(customerDetails, updateButton);
    }


    private void enableDependantEditing(VBox detailsContainer, String phone, String address, String email, String password) {
        detailsContainer.getChildren().clear();

        TextField phoneField = new TextField(phone);
        TextField addressField = new TextField(address);
        TextField emailField = new TextField(email);
        TextField passwordField = new TextField(password);

        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> saveDependantInfo(detailsContainer, phoneField.getText(), addressField.getText(), emailField.getText(), passwordField.getText()));

        detailsContainer.getChildren().addAll(
                new Label("Phone:"), phoneField,
                new Label("Address:"), addressField,
                new Label("Email:"), emailField,
                new Label("Password:"), passwordField,
                saveButton
        );
    }

    private void saveDependantInfo(VBox detailsContainer, String phone, String address, String email, String password) {
        detailsContainer.getChildren().clear();

        Label phoneLabel = new Label("Phone: " + phone);
        Label addressLabel = new Label("Address: " + address);
        Label emailLabel = new Label("Email: " + email);
        Label passwordLabel = new Label("Password: " + password);

        detailsContainer.getChildren().addAll(phoneLabel, addressLabel, emailLabel, passwordLabel);
    }
    @FXML
    private void handleCalculateClaimedSum() {
        clearAdditionalContent();
    }

        private void clearAdditionalContent() {
        additionalContentContainer.getChildren().clear();
    }

}
