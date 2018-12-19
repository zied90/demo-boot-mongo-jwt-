package com.cab.demobootmongojwt.dao;

import com.cab.demobootmongojwt.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends MongoRepository<Product,String> {


}
