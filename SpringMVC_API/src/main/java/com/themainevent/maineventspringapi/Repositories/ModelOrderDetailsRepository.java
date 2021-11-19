package com.themainevent.maineventspringapi.Repositories;

import com.themainevent.maineventspringapi.Models.ModelOrderDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelOrderDetailsRepository extends MongoRepository<ModelOrderDetails, String>{
}
