package com.example.mealplanner;

import com.google.gson.Gson;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIUtility {


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
//    public static Image getNutritionFacts(int id) throws IOException, InterruptedException {
//        String url = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/" + id + "/nutritionLabel.png";
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .header("X-RapidAPI-Key", "70511a685emsh66d197d7522932fp1cf9b2jsn2a45ba6cc657")
//                .header("X-RapidAPI-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
//                .method("GET", HttpRequest.BodyPublishers.noBody())
//                .build();
//        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        return
//
//    }

}
