package com.themainevent.maineventspringapi.Models;

import org.springframework.ui.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ModelInventory {
    private ArrayList<ModelIngredient> ingredients;
    private float costPerServing, qty, minQty;

    public ArrayList<ModelIngredient> getIngredient() {
        return ingredients;
    }

    public void setIngredient(ArrayList<ModelIngredient> ingredient) {
        this.ingredients = ingredient;
    }

    public float getCostPerServing() {
        return costPerServing;
    }

    public void setCostPerServing(float costPerServing) {
        this.costPerServing = costPerServing;
    }

    public float getQty() {
        return qty;
    }

    public void setQty(float qty) {
        this.qty = qty;
    }

    public float getMinQty() {
        return minQty;
    }

    public void setMinQty(float minQty) {
        this.minQty = minQty;
    }
}
