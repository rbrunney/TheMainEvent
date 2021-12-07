package com.themainevent.maineventspringapi.Repositories;

import com.themainevent.maineventspringapi.Models.ModelIngredient;
import com.themainevent.maineventspringapi.Models.ModelUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<ModelUser, String> {
    ModelUser findByUsername(String username);

    ModelUser findBy_id(String _id);
//    List<ModelUser> findByName(String name);
//    ModelUser findFirstByName(String name);
//
//    void deleteByName(String name);

}
