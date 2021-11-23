package com.themainevent.maineventspringapi.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.ui.Model;

import javax.annotation.Generated;

@Document(collection = "Ingredients")
public class ModelIngredient {

    @Id
    private String id;
    private String name;

    public ModelIngredient() {

    }

    public ModelIngredient(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
