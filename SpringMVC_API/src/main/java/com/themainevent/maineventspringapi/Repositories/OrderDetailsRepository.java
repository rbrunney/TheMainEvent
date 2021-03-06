package com.themainevent.maineventspringapi.Repositories;

import com.themainevent.maineventspringapi.Models.ModelMenuItem;
import com.themainevent.maineventspringapi.Models.ModelOrderDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends MongoRepository<ModelOrderDetails, String>{

    @Query("{}")
    List<ModelOrderDetails> findAll();

    ModelOrderDetails findBy_id(String _id);

//    List<ModelOrderDetails> findByName(String name);
//
//    void deleteByName(String name);
}
