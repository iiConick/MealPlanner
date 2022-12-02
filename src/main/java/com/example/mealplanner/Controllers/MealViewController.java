package com.example.mealplanner.Controllers;

import com.example.mealplanner.*;
import com.example.mealplanner.Models.APIResponse;
import com.example.mealplanner.Models.Recipe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MealViewController implements Initializable {

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
    private Label mealsFoundLabel;

    @FXML
    private VBox selectedVBox;


    /**
     * This method gets the selected item from the listview and passes its Id
     * to the next scene via button press
     * @param event
     * @throws IOException
     * @throws InterruptedException
     */
    @FXML
    void getDetails(ActionEvent event) throws IOException, InterruptedException {
        Recipe recipe = listView.getSelectionModel().getSelectedItem();

        SceneChanger.changeScenes(event,"expanded-meal-view.fxml", recipe.getId());

    }

    /**
     * This method will call the API to populate the listview with data based on the parameters provided
     * by the user. If no meals were found by the search term provided, the program displays that there
     * were no results found
     * @param event
     * @throws IOException
     * @throws InterruptedException
     */
    @FXML
    void searchButtonPress(ActionEvent event) throws IOException, InterruptedException {
        APIResponse apiResponse = APIUtility.getRandomRecipe(searchTextField.getText(), amountOfMealsSpinner.getValue());

            listView.getItems().clear();
            List<Recipe> recipes = apiResponse.getRecipes();
            listView.getItems().addAll(recipes);
            if(listView.getItems().size() > 0)
            {
                mealsFoundLabel.setText("Meals Found = " + listView.getItems().size());
            }
            else
            {
                mealsFoundLabel.setText("No Results Found! Try 'chicken'");
            }


    }

    /**
     * This method initializes the spinner value and disabling user input on it. There is a listener that
     * detects when the listview is selected and populates the image and cooking times according to the record selected.
     * This listener also makes the VBox visible. If the value of the cooking times is -1, the labels are not visible.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedVBox.setVisible(false);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 15);
        valueFactory.setValue(1);
        amountOfMealsSpinner.setValueFactory(valueFactory);


        listView.getSelectionModel().selectedItemProperty()
                                    .addListener((obs, old, selectedRecipe)->
        {
                 if(selectedRecipe!= null)
                 {
                     selectedVBox.setVisible(true);
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

                 }
                 else
                 {
                     selectedVBox.setVisible(false);
                 }

        });


    }
}
