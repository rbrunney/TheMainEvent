package com.themainevent.maineventspringapi.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Ingredients")
public class ModelIngredient {

    @Id
    private String _id;
    private String name;

    public ModelIngredient() {

    }

    public ModelIngredient(String name) {
        this.name = name;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ModelIngredient{" +
                "id='" + get_id() + '\'' +
                ", name='" + getName() + '\'' +
                '}';
    }
}
