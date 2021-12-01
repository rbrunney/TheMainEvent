package com.themainevent.maineventspringapi.Repositories;

import com.themainevent.maineventspringapi.Models.ModelIngredient;
import com.themainevent.maineventspringapi.Models.ModelInventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends MongoRepository<ModelInventory, String>{

    List<ModelInventory> findByIngredient(ModelInventory ingredients);
    ModelInventory findFirstByIngredient(ModelInventory ingredients);

    void deleteByIngredient(ModelInventory ingredients);
}