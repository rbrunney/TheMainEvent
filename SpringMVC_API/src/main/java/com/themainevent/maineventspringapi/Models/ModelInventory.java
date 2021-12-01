package com.themainevent.maineventspringapi.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Inventory")
public class ModelInventory {
    @Id
    private String _id;
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

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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
