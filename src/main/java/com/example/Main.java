package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.primaryStage = primaryStage;
        showLoginPage();
    }

    public static void showLoginPage() throws Exception {
        Parent loginPage = FXMLLoader.load(Main.class.getResource("/LoginPage.fxml"));
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(new Scene(loginPage, 300, 150));
        primaryStage.show();
    }

    public static void showMainPage() throws Exception {
        Parent mainPage = FXMLLoader.load(Main.class.getResource("/MainPage.fxml"));
        primaryStage.setTitle("Main Page");
        primaryStage.setScene(new Scene(mainPage, 600, 400));
        primaryStage.show();
    }

    public static void showAdminPage() throws Exception {
        Parent adminPage = FXMLLoader.load(Main.class.getResource("/AdminPage.fxml"));
        primaryStage.setTitle("Admin Page");
        primaryStage.setScene(new Scene(adminPage, 600, 400));
        primaryStage.show();
    }

    public static void showCustomerPage() throws Exception {
        Parent customerPage = FXMLLoader.load(Main.class.getResource("/CustomerPage.fxml"));
        primaryStage.setTitle("Customer Page");
        primaryStage.setScene(new Scene(customerPage, 600, 400));
        primaryStage.show();
    }

    public static void showProviderPage() throws Exception {
        Parent providerPage = FXMLLoader.load(Main.class.getResource("/ProviderPage.fxml"));
        primaryStage.setTitle("Provider Page");
        primaryStage.setScene(new Scene(providerPage, 600, 400));
        primaryStage.show();
    }

    public static void showPolicyOwnerPage() throws Exception {
        Parent policyOwnerPage = FXMLLoader.load(Main.class.getResource("/PolicyOwnerPage.fxml"));
        primaryStage.setTitle("Policy Owner Page");
        primaryStage.setScene(new Scene(policyOwnerPage, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
