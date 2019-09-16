package com.javasampleapproach.webflux.Repository;

import com.javasampleapproach.webflux.model.Model3;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

import java.util.List;

@Transactional
@Repository
public interface ReactiveModel3Repository extends ReactiveMongoRepository <Model3, String> {

    public Flux<Model3> deleteModel3ByMake(String s);

    @Query ("{'id':?0}")
    public void deleteModel3ById (String id);



}
