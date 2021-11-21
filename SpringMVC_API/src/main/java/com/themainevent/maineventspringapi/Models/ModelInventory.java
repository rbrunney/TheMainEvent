package com.themainevent.maineventspringapi.Models;

import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.ui.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Document(collection = "Inventory")
public class ModelInventory {
    private ModelIngredient ingredient;
    private float costPerServing, qty, minQty;

    public ModelInventory(){

    }

    public ModelInventory(ModelIngredient ingredient, float costPerServing, float qty, float minQty){
        this.ingredient = ingredient;
        this.costPerServing = costPerServing;
        this.qty = qty;
        this.minQty = minQty;
    }

    public ModelIngredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(ModelIngredient ingredient) {
        this.ingredient = ingredient;
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
