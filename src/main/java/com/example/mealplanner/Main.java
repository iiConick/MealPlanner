package com.example.mealplanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Initially launches the view/controller
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("meal-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Meal Planner");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("img/logo.png")));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}