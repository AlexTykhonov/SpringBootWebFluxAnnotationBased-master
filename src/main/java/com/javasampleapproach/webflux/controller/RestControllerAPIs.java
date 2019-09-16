package com.javasampleapproach.webflux.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.javasampleapproach.webflux.Repository.ReactiveCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import com.javasampleapproach.webflux.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping(value="/api/customer")
public class RestControllerAPIs {
	// это коллекшия которая хранит данные в формате ключ-значение

	@Autowired
	ReactiveCustomerRepository reactiveCustomerRepository;

	
    @GetMapping("")
    public Flux<Customer> getAll() {
    	return
//
				reactiveCustomerRepository
				.findAll();
//
    }
    
	@GetMapping("/{id}")
    public Mono<Customer> getCustomer(@PathVariable String id) {
		return reactiveCustomerRepository.findById(id);
    }
	
	
	@PostMapping("/post")
    public Mono<ResponseEntity<String>> postCustomer(@RequestBody Customer customer){


		Customer customer1 = reactiveCustomerRepository.save(customer).block();
		

		return Mono.just(new ResponseEntity<>("Post Successfully!", HttpStatus.CREATED));
	}
	
	@PutMapping("/put/{id}")
	public Mono<ResponseEntity<Customer>> putCustomer(@PathVariable String id, @RequestBody Customer customer){
		customer.setId(id);

		Customer oldCustomer = reactiveCustomerRepository.findById(id).block();
		oldCustomer.setAge(customer.getAge());
		oldCustomer.setFirstname(customer.getFirstname());
		oldCustomer.setLastname(customer.getLastname());
		oldCustomer.setId(customer.getId());
		// log on console
		//System.out.println("########### PUT:" + customer);
		
		return Mono.just(new ResponseEntity<>(reactiveCustomerRepository.save(oldCustomer).block(), HttpStatus.CREATED));
	}
	
	@DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> deleteMethod(@PathVariable String id) {

		reactiveCustomerRepository.deleteById(id);
//    	reactiveCustomerRepository.delete(reactiveCustomerRepository.findById(id).block());
//		reactiveCustomerRepository.deleteAll();
		return Mono.just(new ResponseEntity<>("Delete Succesfully!", HttpStatus.ACCEPTED));
    }
}

//заменить хешмеп на репозиторий