package com.example.mealplanner.Models;

import java.util.Arrays;
import java.util.List;

/**
 * This class contains the information I want to be displayed in the second scene.
 */
public class RecipeDetails {
    private int id;
    private String image;

    private String instructions;
    private String title;
    private int servings;
    private int readyInMinutes;
    private int preparationMinutes;
    private int cookingMinutes;
    private String sourceName;
    private Ingredients[] extendedIngredients;


    public RecipeDetails(Ingredients[] extendedIngredients, String sourceName, int servings, int readyInMinutes, int preparationMinutes, int cookingMinutes, String title, int id, String image, String instructions) {
        setServings(servings);
        setReadyInMinutes(readyInMinutes);
        setPreparationMinutes(preparationMinutes);
        setCookingMinutes(cookingMinutes);
        setId(id);
        setImage(image);
        setInstructions(instructions);
        setTitle(title);
        setSourceName(sourceName);
        setIngredients(extendedIngredients);
    }

    public List<Ingredients> getIngredients() {
        return Arrays.asList(extendedIngredients);
    }

    public void setIngredients(Ingredients[] extendedIngredients) {
        this.extendedIngredients = extendedIngredients;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(int readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public int getPreparationMinutes() {
        return preparationMinutes;
    }

    public void setPreparationMinutes(int preparationMinutes) {
        this.preparationMinutes = preparationMinutes;
    }

    public int getCookingMinutes() {
        return cookingMinutes;
    }

    public void setCookingMinutes(int cookingMinutes) {
        this.cookingMinutes = cookingMinutes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
