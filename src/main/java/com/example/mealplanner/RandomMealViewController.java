package com.example.mealplanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class RandomMealViewController implements Initializable {

    @FXML
    private Label cookTimeLabel;

    @FXML
    private Label imageTitleLabel;

    @FXML
    private ListView<Results> listView;

    @FXML
    private ImageView mealImageView;

    @FXML
    private Label prepTimeLabel;

    @FXML
    private Label servingsLabel;

    @FXML
    private Label totalTimeLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }
}