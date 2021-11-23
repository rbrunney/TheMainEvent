package com.themainevent.maineventspringapi.Repositories;

import com.themainevent.maineventspringapi.Models.ModelIngredient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends MongoRepository<ModelIngredient, String>{

    List<ModelIngredient> findByName(String name);
    ModelIngredient findFirstByName(String name);

    void deleteByName(String name);
}