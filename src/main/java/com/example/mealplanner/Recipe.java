package com.example.mealplanner;

public class Recipe {

    private String title;
    private int readyInMinutes;
    private String image;
    private String[] dishTypes;
    private String[] cuisines;
    private String sourceUrl;
    private String instructions;
    private String summary;
    private String[] diets;
    private String[] occasions;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    private boolean dairyFree;
    private int servings;
    private int cookingMinutes;
    private int preparationMinutes;
    private int id;



    public Recipe(String title, int readyInMinutes, String image, String[] dishTypes, String[] cuisines, String sourceUrl, String instructions, String summary, String[] diets,
                  String[] occasions, boolean vegetarian, boolean vegan, boolean glutenFree,
                  boolean dairyFree, int servings, int cookingMinutes, int preparationMinutes, int id) {

        setTitle(title);
        setReadyInMinutes(readyInMinutes);
        setImage(image);
        setDishTypes(dishTypes);
        setCuisines(cuisines);
        setSourceUrl(sourceUrl);
        setInstructions(instructions);
        setSummary(summary);
        setDiets(diets);
        setOccasions(occasions);
        setVegetarian(vegetarian);
        setVegan(vegan);
        setGlutenFree(glutenFree);
        setDairyFree(dairyFree);
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

    public String[] getDishTypes() {
        return dishTypes;
    }

    public void setDishTypes(String[] dishTypes) {
        this.dishTypes = dishTypes;
    }

    public String[] getCuisines() {
        return cuisines;
    }

    public void setCuisines(String[] cuisines) {
        this.cuisines = cuisines;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String[] getDiets() {
        return diets;
    }

    public void setDiets(String[] diets) {
        this.diets = diets;
    }

    public String[] getOccasions() {
        return occasions;
    }

    public void setOccasions(String[] occasions) {
        this.occasions = occasions;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public boolean isDairyFree() {
        return dairyFree;
    }

    public void setDairyFree(boolean dairyFree) {
        this.dairyFree = dairyFree;
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
}
