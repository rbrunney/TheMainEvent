package com.themainevent.maineventspringapi.Repositories;

import com.themainevent.maineventspringapi.Models.ModelUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelUserRepository extends MongoRepository<ModelUser, String> {

}
