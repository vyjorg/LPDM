package com.lpdm.msorder.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@Getter @Setter
@ToString
public class Stock {

    private int id;
    private Category category;
    private LocalDate expireDate;
    private String packaging;
    private int unitByPackage;
}
