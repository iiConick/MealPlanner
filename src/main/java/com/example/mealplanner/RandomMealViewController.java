package com.example.mealplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class RandomMealViewController implements Initializable {

    @FXML
    private Spinner<Integer> amountOfMealsSpinner;

    @FXML
    private Label cookTimeLabel;

    @FXML
    private Label imageTitleLabel;

    @FXML
    private ListView<Recipe> listView;

    @FXML
    private ImageView mealImageView;

    @FXML
    private Label prepTimeLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    private Label servingsLabel;

    @FXML
    private Label totalTimeLabel;

    @FXML
    private VBox selectedVBox;

    @FXML
    void getDetails(ActionEvent event) throws IOException, InterruptedException {
        Recipe recipe = listView.getSelectionModel().getSelectedItem();

        SceneChanger.changeScenes(event,"expanded-meal-view.fxml", recipe.getId());

    }

    @FXML
    void searchButtonPress(ActionEvent event) throws IOException, InterruptedException {
        APIResponse apiResponse = APIUtility.getRandomRecipe(searchTextField.getText(), amountOfMealsSpinner.getValue());

            listView.getItems().clear();
            List<Recipe> recipes = apiResponse.getRecipes();
            listView.getItems().addAll(recipes);




    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedVBox.setVisible(false);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        valueFactory.setValue(1);
        amountOfMealsSpinner.setValueFactory(valueFactory);

        listView.getSelectionModel().selectedItemProperty()
                                    .addListener((obs, old, selectedRecipe)->
        {
                 if(selectedRecipe!= null)
                 {
                     selectedVBox.setVisible(true);
                     try {
                         mealImageView.setImage(new Image(selectedRecipe.getImage()));
                         imageTitleLabel.setText(selectedRecipe.getTitle());
                         if(selectedRecipe.getCookingMinutes() != -1)
                         {
                             cookTimeLabel.setVisible(true);
                             cookTimeLabel.setText("Cook Time: " + selectedRecipe.getCookingMinutes());
                         }
                         else
                         {
                             cookTimeLabel.setVisible(false);
                         }

                         if(selectedRecipe.getPreparationMinutes() != -1)
                         {
                             prepTimeLabel.setVisible(true);
                             prepTimeLabel.setText("Prep Time: " + selectedRecipe.getPreparationMinutes());
                         }
                         else
                         {
                             prepTimeLabel.setVisible(false);
                         }

                         servingsLabel.setText("Servings: " + selectedRecipe.getServings());
                         totalTimeLabel.setText("Total Time: " + selectedRecipe.getReadyInMinutes());

                     } catch (IllegalArgumentException e)
                     {
                         mealImageView.setImage(new Image(Main.class
                                 .getResourceAsStream("images/default_poster.png")));
                     }
                 }
                 else
                 {
                     selectedVBox.setVisible(false);
                 }

        });


    }
}
