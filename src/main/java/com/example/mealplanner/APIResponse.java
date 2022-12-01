package com.example.mealplanner;


import java.util.Arrays;
import java.util.List;

public class APIResponse {

    private Results[] results;

    public APIResponse(Results[] recipes) {
        setRecipes(recipes);
    }

    public List<Results> getRecipes() {
        return Arrays.asList(results);
    }

    public void setRecipes(Results[] recipes) {
        this.results = recipes;
    }
}
