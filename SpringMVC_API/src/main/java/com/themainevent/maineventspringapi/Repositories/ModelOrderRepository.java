package com.themainevent.maineventspringapi.Repositories;

import com.themainevent.maineventspringapi.Models.ModelOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelOrderRepository extends MongoRepository<ModelOrder, String>{
}
