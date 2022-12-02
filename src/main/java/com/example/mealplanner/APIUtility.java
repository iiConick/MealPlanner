package com.example.mealplanner;

import com.example.mealplanner.Models.APIResponse;
import com.example.mealplanner.Models.RecipeDetails;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIUtility {

    /**
     * This method concatenates a url to call the api with using user inputted search terms and the amount of
     * recipes they want returned. The api call is then stored in a Gson object and returned to the mealviewcontroller to display
     * data in the view
     * @param search
     * @param recipeAmount
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static APIResponse getRandomRecipe(String search, int recipeAmount) throws IOException, InterruptedException {

        String url = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/complexSearch?query=";

        String newTerm = search.replaceAll(",","%2C");
        String replaceSpace = newTerm.replaceAll(" ","%20");

        url += replaceSpace + "&instructionsRequired=true&addRecipeInformation=true&number=" + recipeAmount;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-RapidAPI-Key", "70511a685emsh66d197d7522932fp1cf9b2jsn2a45ba6cc657")
                .header("X-RapidAPI-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(response.body(), APIResponse.class);

    }

    /**
     * This method makes a different API call using only the id passed from the first scene in the url.
     * The information returned is stored in a Gson object and returned to the expandedmealviewcontroller to populate
     * the view with data
     * @param id
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static RecipeDetails getRecipeDetails(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/" + id + "/information"))
                .header("X-RapidAPI-Key", "70511a685emsh66d197d7522932fp1cf9b2jsn2a45ba6cc657")
                .header("X-RapidAPI-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(response.body(), RecipeDetails.class);

    }



}
