package com.themainevent.maineventspringapi.Repositories;

import com.themainevent.maineventspringapi.Models.ModelIngredient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends MongoRepository<ModelIngredient, String>{

    List<ModelIngredient> findByName(String name);

    void deleteByName(String name);

    Optional<ModelIngredient> findById(String id);

    List<ModelIngredient> findByIdAndName(String id, String name);

}