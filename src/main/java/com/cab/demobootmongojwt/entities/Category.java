package com.cab.demobootmongojwt.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @Getter
    @Setter
    private String id;
    private String name;
    @DBRef
    private Collection<Product>products=new ArrayList<>();

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

