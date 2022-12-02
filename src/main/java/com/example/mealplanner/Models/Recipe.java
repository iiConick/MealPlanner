package com.example.mealplanner.Models;

/**
 * Stores the main information of the json file. Everything inside the Recipe[] array that
 * I want to use for the first scene is in this class
 */
public class Recipe {

    private String title;
    private int readyInMinutes;
    private String image;
    private int servings;
    private int cookingMinutes;
    private int preparationMinutes;
    private int id;



    public Recipe(String title, int readyInMinutes, String image, int servings, int cookingMinutes, int preparationMinutes, int id) {

        setTitle(title);
        setReadyInMinutes(readyInMinutes);
        setImage(image);
        setCookingMinutes(cookingMinutes);
        setPreparationMinutes(preparationMinutes);
        setServings(servings);
        setId(id);

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(int readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public int getCookingMinutes() {
        return cookingMinutes;
    }

    public void setCookingMinutes(int cookingMinutes) {
        this.cookingMinutes = cookingMinutes;
    }

    public int getPreparationMinutes() {
        return preparationMinutes;
    }

    public void setPreparationMinutes(int preparationMinutes) {
        this.preparationMinutes = preparationMinutes;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString()
    {
        return String.format("%s",title);
    }
}
