package com.example.mealplanner;


import java.util.Arrays;
import java.util.List;

public class APIResponse {

    private Recipe[] results;

    public APIResponse(Recipe[] recipes) {
        setRecipes(recipes);
    }

    public List<Recipe> getRecipes() {
        return Arrays.asList(results);
    }

    public void setRecipes(Recipe[] recipes) {
        this.results = recipes;
    }
}
