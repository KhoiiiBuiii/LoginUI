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


    public static void showAdminPage() throws Exception {
        Parent adminPage = FXMLLoader.load(Main.class.getResource("/AdminPage.fxml"));
        primaryStage.setTitle("Admin Page");
        primaryStage.setScene(new Scene(adminPage, 600, 400));
        primaryStage.show();
    }


    public static void showPolicyOwnerPage() throws Exception {
        Parent policyOwnerPage = FXMLLoader.load(Main.class.getResource("/PolicyOwnerPage.fxml"));
        primaryStage.setTitle("Policy Owner Page");
        primaryStage.setScene(new Scene(policyOwnerPage, 600, 400));
        primaryStage.show();
    }

    public static void showPolicyHolderPage() throws Exception {
        Parent policyHolderPage = FXMLLoader.load(Main.class.getResource("/PolicyHolderPage.fxml"));
        primaryStage.setTitle("Policy Holder Page");
        primaryStage.setScene(new Scene(policyHolderPage, 800, 600));
        primaryStage.show();
    }

    public static void showDependantPage() throws Exception {
        Parent dependantPage = FXMLLoader.load(Main.class.getResource("/DependantPage.fxml"));
        primaryStage.setTitle("Dependant Page");
        primaryStage.setScene(new Scene(dependantPage, 800, 600));
        primaryStage.show();
    }

    public static void logout() throws Exception {
        showLoginPage();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
