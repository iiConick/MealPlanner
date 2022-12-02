package com.example.mealplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ExpandedMealViewController implements Initializable {
    @FXML
    private Label cookTimeLabel;

    @FXML
    private Label foodTitleLabel;

    @FXML
    private ListView<Ingredients> ingredientsListView;

    @FXML
    private TextArea instructionsTextArea;

    @FXML
    private ImageView mealImageView;

    @FXML
    private Label prepTimeLabel;

    @FXML
    private Label servingsLabel;

    @FXML
    private Label sourceNameLabel;


    @FXML
    private Label totalTimeLabel;

    public void getRecipeDetails(int id) throws IOException, InterruptedException {
        RecipeDetails recipeDetails = APIUtility.getRecipeDetails(id);
        mealImageView.setImage(new Image(recipeDetails.getImage()));
        sourceNameLabel.setText(recipeDetails.getSourceName());
        foodTitleLabel.setText(recipeDetails.getTitle());
        if(recipeDetails.getPreparationMinutes() != -1)
        {
            prepTimeLabel.setVisible(true);
            prepTimeLabel.setText("" + recipeDetails.getPreparationMinutes());
        }
        else
        {
            prepTimeLabel.setVisible(false);
        }
        if(recipeDetails.getCookingMinutes() != -1)
        {
            cookTimeLabel.setVisible(true);
            cookTimeLabel.setText("" + recipeDetails.getCookingMinutes());
        }
        else
        {
            cookTimeLabel.setVisible(false);
        }
        cookTimeLabel.setText("" + recipeDetails.getCookingMinutes());
        totalTimeLabel.setText("" + recipeDetails.getReadyInMinutes());
        servingsLabel.setText("Servings: " + recipeDetails.getServings());
        List<Ingredients> ingredients = recipeDetails.getIngredients();
        ingredientsListView.getItems().addAll(ingredients);
        instructionsTextArea.setText(recipeDetails.getInstructions());

    }

    @FXML
    void backButtonPressed(ActionEvent event) throws IOException, InterruptedException {
        SceneChanger.changeScenes(event,"random-meal-view.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}




