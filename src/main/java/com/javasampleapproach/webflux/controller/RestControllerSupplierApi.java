package com.javasampleapproach.webflux.controller;

import com.javasampleapproach.webflux.Repository.ReactiveCustomerRepository;
import com.javasampleapproach.webflux.Repository.ReactiveSupplierRepository;
import com.javasampleapproach.webflux.model.Customer;
import com.javasampleapproach.webflux.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping(value="/api/supplier")
public class RestControllerSupplierApi {

    @Autowired
    ReactiveSupplierRepository reactiveSupplierRepository;

    @GetMapping("")
    Flux<Supplier> getAll () {
        return reactiveSupplierRepository.findAll();

            }
    @PostMapping("")
    Mono<Supplier> postSupplier (@RequestBody Supplier supplier) {
        return reactiveSupplierRepository.save(supplier);
    }


}
