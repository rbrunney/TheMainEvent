package com.themainevent.maineventspringapi.Repositories;

import com.themainevent.maineventspringapi.Models.ModelIngredient;
import com.themainevent.maineventspringapi.Models.ModelUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<ModelUser, String> {
    @Query
    ModelUser findByUsername(String username);
//    List<ModelUser> findByName(String name);
//    ModelUser findFirstByName(String name);
//
//    void deleteByName(String name);

}
