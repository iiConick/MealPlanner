package com.example.mealplanner.Models;


import com.example.mealplanner.Models.Recipe;

import java.util.Arrays;
import java.util.List;

/**
 * This stores the recipe array's setter/getters. Recipe[] is the main array of the json file
 */
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
