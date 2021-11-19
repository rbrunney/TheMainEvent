package com.themainevent.maineventspringapi.Repositories;

import com.themainevent.maineventspringapi.Models.ModelMenuItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelMenuItemRepository extends MongoRepository<ModelMenuItem, String>{
}