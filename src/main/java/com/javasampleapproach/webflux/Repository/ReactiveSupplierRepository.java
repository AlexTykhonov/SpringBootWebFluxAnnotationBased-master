package com.javasampleapproach.webflux.Repository;

import com.javasampleapproach.webflux.model.Supplier;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveSupplierRepository extends ReactiveMongoRepository <Supplier, String> {
}
