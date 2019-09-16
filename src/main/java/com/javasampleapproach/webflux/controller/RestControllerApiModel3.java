package com.javasampleapproach.webflux.controller;

import com.javasampleapproach.webflux.Repository.ReactiveModel3Repository;
import com.javasampleapproach.webflux.model.Model3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping(value="/api/model3")
public class RestControllerApiModel3 {

    @Autowired
    ReactiveModel3Repository reactiveModel3Repository;


    @GetMapping ("")
    public Flux<Model3> getAllCars () {
        return reactiveModel3Repository.findAll();
    }

    @PostMapping ("")
    public Mono<Model3> putTheCar (@RequestBody Model3 model3) {
        return reactiveModel3Repository.save(model3);
    }

    @DeleteMapping ("/{make}")
    public  Flux <Model3> delTheCar (@PathVariable String make) {
        return reactiveModel3Repository.deleteModel3ByMake(make);
    }

    @DeleteMapping ("/del/{id}")
    public void delTheCarById (@PathVariable String id) {
        reactiveModel3Repository.deleteModel3ById(id);
    }
}
