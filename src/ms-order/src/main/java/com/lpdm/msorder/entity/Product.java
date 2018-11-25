package com.lpdm.msorder.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@NoArgsConstructor
@Getter @Setter
@ToString
public class Product {

    @Id
    private int id;
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private Category category;

    private String label;
    private double price;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private Stock stock;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private User producer;

    private String picture;
}
