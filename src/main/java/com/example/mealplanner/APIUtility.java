package com.example.mealplanner;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {

    /**
     * This method will call the OMDB API with the specified
     * search term
     * @return ApiResponse is the Java object created from the JSON
     */
    public static void getRandomRecipe(String query[], String recipeAmount) throws IOException, InterruptedException {

        String url = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/complexSearch?";

        for (String keyWord: query) {
            if(keyWord.contains(","))
            {
                keyWord.replace(",","%2C");
            }
            if(keyWord.contains(" "))
            {
                keyWord.replace(" ","%20");
            }

        }
        url += "&instructionsRequired=true&addRecipeInformation=true&number=" + recipeAmount;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-RapidAPI-Key", "70511a685emsh66d197d7522932fp1cf9b2jsn2a45ba6cc657")
                .header("X-RapidAPI-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("jsonData.json")));

        //Gson gson = new Gson();
        //return gson.fromJson(response.body(), APIResponse.class);



    }

}
