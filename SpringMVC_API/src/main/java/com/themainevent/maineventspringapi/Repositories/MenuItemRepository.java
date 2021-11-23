package com.themainevent.maineventspringapi.Repositories;

import com.themainevent.maineventspringapi.Models.ModelIngredient;
import com.themainevent.maineventspringapi.Models.ModelMenuItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends MongoRepository<ModelMenuItem, String>{

    List<ModelMenuItem> findByNameOfDish(String name);
    ModelMenuItem findFirstByNameOfDish(String name);

    void deleteByNameOfDish(String name);
}