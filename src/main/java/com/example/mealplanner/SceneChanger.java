package com.example.mealplanner;

import com.example.mealplanner.Controllers.ExpandedMealViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {

    /**
     * This method changes scenes while passing the id parameter between scenes. A method within the next controller is called
     * with the id parameter passed in it. The next scene is then loaded.
     * @param event
     * @param fxmlFile
     * @param id
     * @throws IOException
     * @throws InterruptedException
     */
    public static void changeScenes(ActionEvent event, String fxmlFile, int id) throws IOException, InterruptedException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());

        //Grab the controller from the next scene
        ExpandedMealViewController controller = fxmlLoader.getController();
        controller.getRecipeDetails(id);

        //get the stage from the ActionEvent
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Meal Details");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method overloads the changeScenes method, requiring one less parameter to be passed through (id). This method is if
     * no information is required when changing scenes
     * @param event
     * @param fxmlFile
     * @throws IOException
     * @throws InterruptedException
     */
    public static void changeScenes(ActionEvent event, String fxmlFile) throws IOException, InterruptedException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());

        //get the stage from the ActionEvent
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Meal Planner");

        stage.setScene(scene);
        stage.show();
    }
}
