package com.example.mealplanner.Models;

/**
 * Contains ingredient names to populate listview
 */
public class Ingredients {
    private String original;

    public Ingredients(String original) {
        setOriginal(original);
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String toString()
    {
        return String.format("%s", original);
    }
}
