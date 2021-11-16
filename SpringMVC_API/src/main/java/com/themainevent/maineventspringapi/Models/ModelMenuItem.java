package com.themainevent.maineventspringapi.Models;

import java.util.ArrayList;

public class ModelMenuItem {
    private ArrayList<ModelIngredient> ingredients;
    private float price;
    private float ingredientsCost;

    public ArrayList<ModelIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<ModelIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getIngredientsCost() {
        return ingredientsCost;
    }

    public void setIngredientsCost(float ingredientsCost) {
        this.ingredientsCost = ingredientsCost;
    }
}
