package com.example;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.TreeMap;
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
    @FXML
    private HBox searchBox;
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
        searchBox.setVisible(false);
        claimsContainer.setVisible(false);
        searchBox.setManaged(false);
        claimsContainer.setManaged(false);

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

    @FXML
    public void handleManageClaimsButton() {
        clearAdditionalContent();
        Label titleLabel = new Label("Manage Claims");
        additionalContentContainer.getChildren().add(titleLabel);
        searchBox.setVisible(false);
        claimsContainer.setVisible(false);
        searchBox.setManaged(false);
        claimsContainer.setManaged(false);

        HBox buttonsContainer = new HBox(10);
        Button reviewClaimsButton = new Button("Review Claims");
        Button proposedClaimsButton = new Button("Proposed Claims");
        buttonsContainer.getChildren().add(reviewClaimsButton);
        buttonsContainer.getChildren().add(proposedClaimsButton);
        additionalContentContainer.getChildren().add(buttonsContainer);

        reviewClaimsButton.setOnAction(event -> handleReviewClaimsButton());
        proposedClaimsButton.setOnAction(event -> handleProposedClaimsButton());
    }
    @FXML
    private void handleReviewClaimsButton() {
        clearAdditionalContent();

        searchBox.setVisible(true);
        claimsContainer.setVisible(true);
        searchBox.setManaged(true);
        claimsContainer.setManaged(true);

        initializeClaimsData();
    }


    private void initializeClaimsData() {
        claimsData = new TreeMap<>();
        // Mock data
        claimsData.put("Claim 1", "Claim ID: 125");
        claimsData.put("Claim 2", "Claim ID: 278");
        claimsData.put("Claim 3", "Claim ID: 316");
        claimsData.put("Claim 4", "Claim ID: 467");
        claimsData.put("Claim 5", "Claim ID: 590");

        displayClaims(claimsData);
    }


    @FXML
    private void handleSearchAction(ActionEvent event) {
        String searchText = searchField.getText().trim();
        if (searchText.isEmpty()) {
            displayClaims(claimsData);
        } else {
            Map<String, String> searchResults = searchClaims(searchText);
            displayClaims(searchResults);
        }
    }

    private Map<String, String> searchClaims(String searchText) {
        Map<String, String> searchResults = new TreeMap<>();
        for (Map.Entry<String, String> entry : claimsData.entrySet()) {
            if (entry.getValue().contains(searchText)) {
                searchResults.put(entry.getKey(), entry.getValue());
            }
        }
        return searchResults;
    }

    private void displayClaims(Map<String, String> claims) {
        claimsContainer.getChildren().clear();

        for (Map.Entry<String, String> entry : claims.entrySet()) {
            String claimID = entry.getKey();
            String claimInfo = entry.getValue();

            Label claimLabel = new Label(claimInfo);
            Button approveButton = new Button("Approve");
            Button denyButton = new Button("Deny");

            approveButton.setOnAction(event -> handleApproveButton(claimID));
            denyButton.setOnAction(event -> handleDenyButton(claimID));

            HBox claimBox = new HBox(10);
            claimBox.getChildren().addAll(claimLabel, approveButton, denyButton);
            claimsContainer.getChildren().add(claimBox);
        }
    }
    private void handleProposedClaimsButton() {
        clearAdditionalContent();

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
        clearAdditionalContent();

        Label titleLabel = new Label("Claim Details: " + claim);
        additionalContentContainer.getChildren().add(titleLabel);

        String claimDate = "2024-05-20";
        String insuredPerson = "John Doe";
        String cardNumber = "1234 5678 9012 3456";
        String examDate = "2024-05-25";
        String documents = "sample-document.pdf";
        String claimAmount = "$1000";
        String receiverBankingInfo = "Bank Name: ABC Bank, Account Number: 1234567890";

        Hyperlink documentLink = new Hyperlink(documents);
        documentLink.setOnAction(event -> showImageView(documents));

        Label claimDateLabel = new Label("Claim Date: " + claimDate);
        Label insuredPersonLabel = new Label("Insured Person: " + insuredPerson);
        Label cardNumberLabel = new Label("Card Number: " + cardNumber);
        Label examDateLabel = new Label("Exam Date: " + examDate);
        Label documentLabel = new Label("Document: ");
        Label claimAmountLabel = new Label("Claim Amount: " + claimAmount);
        Label receiverBankingInfoLabel = new Label("Receiver Banking Info: " + receiverBankingInfo);

        Button approveButton = new Button("Approve");
        Button denyButton = new Button("Deny");

        approveButton.setOnAction(event -> handleApproveButton(claim));
        denyButton.setOnAction(event -> handleDenyButton(claim));

        HBox buttonsContainer = new HBox(10);
        buttonsContainer.getChildren().addAll(approveButton, denyButton);

        VBox claimDetails = new VBox(5);
        claimDetails.getChildren().addAll(
                claimDateLabel,
                insuredPersonLabel,
                cardNumberLabel,
                examDateLabel,
                documentLabel,
                documentLink,
                claimAmountLabel,
                receiverBankingInfoLabel,
                buttonsContainer
        );

        additionalContentContainer.getChildren().add(claimDetails);
    }

    private void showImageView(String document) {
        Stage imageStage = new Stage();
        ImageView imageView = new ImageView(new Image("file:" + document));
        imageView.setFitWidth(600);
        imageView.setFitHeight(800);
        VBox vbox = new VBox(imageView);
        Scene scene = new Scene(vbox);
        imageStage.setScene(scene);
        imageStage.show();
    }

    private void handleApproveButton(String claimID) {
        // Approve function here :D
    }

    private void handleDenyButton(String claimID) {
        // Deny function here :D
    }

    public void handleManageSurveyorsButton() {
        clearAdditionalContent();

        Label titleLabel = new Label("Manage Surveyors");
        additionalContentContainer.getChildren().add(titleLabel);
        searchBox.setVisible(false);
        claimsContainer.setVisible(false);
        searchBox.setManaged(false);
        claimsContainer.setManaged(false);

        String[] surveyors = {"Surveyor 1", "Surveyor 2", "Surveyor 3"};
        VBox surveyorsList = new VBox(5);
        for (String surveyor : surveyors) {
            Hyperlink surveyorLink = new Hyperlink(surveyor);
            surveyorLink.setOnAction(event -> showSurveyorOptions(surveyor));
            surveyorsList.getChildren().add(surveyorLink);
        }
        additionalContentContainer.getChildren().add(surveyorsList);
    }

    private void showSurveyorOptions(String surveyor) {
        clearAdditionalContent();

        Label titleLabel = new Label("Surveyor Details: " + surveyor);
        additionalContentContainer.getChildren().add(titleLabel);

        String id = "123-456-7890";
        String name = "123 Main St, City";
        String claims = "Claim 1, Claim 2";

        Label idLabel = new Label("ID: " + id);
        Label nameLabel = new Label("Name: " + name);
        Label claimsLabel = new Label("Claims: " + claims);

        VBox surveyorDetails = new VBox(5);
        surveyorDetails.getChildren().addAll(idLabel, nameLabel, claimsLabel);


        additionalContentContainer.getChildren().addAll(surveyorDetails);
    }

    private void clearAdditionalContent() {
        additionalContentContainer.getChildren().clear();
    }

}