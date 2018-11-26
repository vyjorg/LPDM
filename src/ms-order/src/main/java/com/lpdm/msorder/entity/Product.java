package com.lpdm.msorder.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@NoArgsConstructor
@Getter @Setter
@ToString
public class Product {

    private int id;
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Category category;

    private String label;
    private double price;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Stock stock;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private User producer;

    private String picture;

    Product(int id, String name){
        this.id = id;
        this.name = name;
    }
}
