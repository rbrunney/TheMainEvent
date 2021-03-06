package com.themainevent.maineventspringapi.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "MenuItems")
public class ModelMenuItem {
    @Id
    private String _id;
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

    @Override
    public String toString() {
        return nameOfDish;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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
