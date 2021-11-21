package com.themainevent.maineventspringapi.Models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "MenuItems")
public class ModelMenuItem {
    private ArrayList<ModelIngredient> ingredients;
    private String nameOfDish;
    private float price;
    private float ingredientsCost;

    public ModelMenuItem(){

    }

    public ModelMenuItem(String nameOfDish, ArrayList<ModelIngredient> ingredients, float price, float ingredientsCost){
        this.nameOfDish = nameOfDish;
        this.ingredients = ingredients;
        this.price = price;
        this.ingredientsCost = ingredientsCost;
    }

    public String getNameOfDish() {
        return nameOfDish;
    }

    public void setNameOfDish(String nameOfDish) {
        this.nameOfDish = nameOfDish;
    }

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
