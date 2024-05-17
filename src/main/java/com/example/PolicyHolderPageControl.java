package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.File;
import javafx.scene.Scene;
import javafx.scene.control.*;


public class PolicyHolderPageControl {
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
    private Button manageDependantsButton;
    private File uploadedFile;

    public void initialize() {
        String loggedInUserName = getLoggedInUserName();
        if (loggedInUserName != null && !loggedInUserName.isEmpty()) {
            welcomeLabel.setText("Welcome Back, " + loggedInUserName);
        } else {
            welcomeLabel.setText("Welcome!");
        }
    }

    private String getLoggedInUserName() {
        return "Policy Holder";
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

    public void handleManageClaimsButton() {
        clearAdditionalContent();

        Label titleLabel = new Label("Manage Claims");
        additionalContentContainer.getChildren().add(titleLabel);

        HBox buttonsContainer = new HBox(10);
        Button fileButton = new Button("File");
        Button viewButton = new Button("View");
        Button updateButton = new Button("Update");

        fileButton.setOnAction(event -> handleFileClaim());
        viewButton.setOnAction(event -> viewClaims());
        updateButton.setOnAction(event -> handleUpdateClaim());

        buttonsContainer.getChildren().addAll(fileButton, viewButton, updateButton);
        additionalContentContainer.getChildren().add(buttonsContainer);
    }

    private void handleFileClaim() {
        clearAdditionalContent();

        TextField claimDateField = new TextField();
        TextField insuredPersonField = new TextField();
        TextField cardNumberField = new TextField();
        TextField examDateField = new TextField();
        Button uploadButton = new Button("Upload Document");
        uploadButton.setOnAction(event -> handleFileUpload(uploadButton));
        TextField claimAmountField = new TextField();
        TextField receiverBankingInfoField = new TextField();

        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> saveClaimDetails(claimDateField.getText(), insuredPersonField.getText(), cardNumberField.getText(), examDateField.getText(), uploadedFile != null ? uploadedFile.getName() : "", claimAmountField.getText(), receiverBankingInfoField.getText()));

        VBox claimForm = new VBox(5);
        claimForm.getChildren().addAll(
                new Label("Claim Date:"), claimDateField,
                new Label("Insured Person:"), insuredPersonField,
                new Label("Card Number:"), cardNumberField,
                new Label("Exam Date:"), examDateField,
                new Label("Document:"), uploadButton,
                new Label("Claim Amount:"), claimAmountField,
                new Label("Receiver Banking Info:"), receiverBankingInfoField,
                saveButton
        );

        additionalContentContainer.getChildren().add(claimForm);
    }

    private void handleFileUpload(Button button) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        File file = fileChooser.showOpenDialog(button.getScene().getWindow());
        if (file != null) {
            if (file.getName().toLowerCase().endsWith(".pdf")) {
                uploadedFile = file;
                button.setText(file.getName());
            } else {
                showError("File must be in PDF format.");
            }
        }
    }

    private void viewClaims() {
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

        VBox claimDetails = new VBox(5);
        claimDetails.getChildren().addAll(
                new Label("Claim Date: " + claimDate),
                new Label("Insured Person: " + insuredPerson),
                new Label("Card Number: " + cardNumber),
                new Label("Exam Date: " + examDate),
                new Label("Document: "), documentLink,
                new Label("Claim Amount: " + claimAmount),
                new Label("Receiver Banking Info: " + receiverBankingInfo)
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

    private void handleUpdateClaim() {
        clearAdditionalContent();

        String claimDate = "2024-05-20";
        String insuredPerson = "John Doe";
        String cardNumber = "1234 5678 9012 3456";
        String examDate = "2024-05-25";
        String documents = "sample-document.pdf";
        String claimAmount = "$1000";
        String receiverBankingInfo = "Bank Name: ABC Bank, Account Number: 1234567890";

        TextField claimDateField = new TextField(claimDate);
        TextField insuredPersonField = new TextField(insuredPerson);
        TextField cardNumberField = new TextField(cardNumber);
        TextField examDateField = new TextField(examDate);
        Hyperlink documentLink = new Hyperlink(documents);
        documentLink.setOnAction(event -> showImageView(documents));
        Button uploadNewButton = new Button("Upload New");
        uploadNewButton.setOnAction(event -> handleFileUpload(uploadNewButton));
        TextField claimAmountField = new TextField(claimAmount);
        TextField receiverBankingInfoField = new TextField(receiverBankingInfo);

        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> saveClaimDetails(claimDateField.getText(), insuredPersonField.getText(), cardNumberField.getText(), examDateField.getText(), uploadedFile != null ? uploadedFile.getName() : documents, claimAmountField.getText(), receiverBankingInfoField.getText()));

        VBox updateForm = new VBox(5);
        updateForm.getChildren().addAll(
                new Label("Claim Date:"), claimDateField,
                new Label("Insured Person:"), insuredPersonField,
                new Label("Card Number:"), cardNumberField,
                new Label("Exam Date:"), examDateField,
                new Label("Document: "), documentLink,
                uploadNewButton,
                new Label("Claim Amount:"), claimAmountField,
                new Label("Receiver Banking Info:"), receiverBankingInfoField,
                saveButton
        );

        additionalContentContainer.getChildren().add(updateForm);
    }

    private void saveClaimDetails(String claimDate, String insuredPerson, String cardNumber, String examDate, String document, String claimAmount, String receiverBankingInfo) {
        clearAdditionalContent();

        Hyperlink documentLink = new Hyperlink(document);
        documentLink.setOnAction(event -> showImageView(document));

        VBox claimDetails = new VBox(5);
        claimDetails.getChildren().addAll(
                new Label("Claim Date: " + claimDate),
                new Label("Insured Person: " + insuredPerson),
                new Label("Card Number: " + cardNumber),
                new Label("Exam Date: " + examDate),
                new Label("Document: "), documentLink,
                new Label("Claim Amount: " + claimAmount),
                new Label("Receiver Banking Info: " + receiverBankingInfo)
        );

        additionalContentContainer.getChildren().add(claimDetails);
    }

    public void handleManageDependantsButton() {
        clearAdditionalContent();

        Label titleLabel = new Label("Manage Dependants");
        additionalContentContainer.getChildren().add(titleLabel);

        String[] dependants = {"Dependant 1", "Dependant 2", "Dependant 3"};
        VBox dependantsList = new VBox(5);
        for (String dependant : dependants) {
            Hyperlink dependantLink = new Hyperlink(dependant);
            dependantLink.setOnAction(event -> showDependantOptions(dependant));
            dependantsList.getChildren().add(dependantLink);
        }
        additionalContentContainer.getChildren().add(dependantsList);
    }

    private void showDependantOptions(String dependant) {
        clearAdditionalContent();

        Label titleLabel = new Label("Dependant Details: " + dependant);
        additionalContentContainer.getChildren().add(titleLabel);

        String phone = "123-456-7890";
        String address = "123 Main St, City";
        String email = "dependant@example.com";
        String password = "password";

        Label phoneLabel = new Label("Phone: " + phone);
        Label addressLabel = new Label("Address: " + address);
        Label emailLabel = new Label("Email: " + email);
        Label passwordLabel = new Label("Password: " + password);

        VBox dependantDetails = new VBox(5);
        dependantDetails.getChildren().addAll(phoneLabel, addressLabel, emailLabel, passwordLabel);

        Button updateButton = new Button("Update");
        updateButton.setOnAction(event -> enableDependantEditing(dependantDetails, phone, address, email, password));

        additionalContentContainer.getChildren().addAll(dependantDetails, updateButton);
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

    private void clearAdditionalContent() {
        additionalContentContainer.getChildren().clear();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}






