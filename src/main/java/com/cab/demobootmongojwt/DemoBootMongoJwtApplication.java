package com.cab.demobootmongojwt;

import com.cab.demobootmongojwt.dao.CategoryRepository;
import com.cab.demobootmongojwt.dao.ProductRepository;

import com.cab.demobootmongojwt.entities.Category;
import com.cab.demobootmongojwt.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.ArrayList;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoBootMongoJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoBootMongoJwtApplication.class, args);


    }
    @Bean
    CommandLineRunner start(CategoryRepository categoryRepository , ProductRepository productRepository) {
        return args -> {
            categoryRepository.deleteAll();
            Stream.of("C1 ordinateur", "C2 Imprimentes").forEach(c -> {
                categoryRepository.save(new Category(c.split(" ")[0], c.split(" ")[1], new ArrayList<>()));
            });
            categoryRepository.findAll().forEach(System.out::println);

            productRepository.deleteAll();
            Category c1=categoryRepository.findById("C1").get();
            Stream.of("P1","P2","P3","P4").forEach(name->{
               Product p= productRepository.save(new Product(null,name,Math.random()*100,c1));
                c1.getProducts().add(p);
                categoryRepository.save(c1);
            });
            Category c2=categoryRepository.findById("C2").get();
            Stream.of("P5","P6","P7","P8").forEach(name->{
               Product p= productRepository.save(new Product(null,name,Math.random()*100,c2));
            c2.getProducts().add(p);
            categoryRepository.save(c2);
            });
            productRepository.findAll().forEach(System.out::println);

        };

    }

    }



