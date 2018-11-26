package com.lpdm.msorder.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.Transient;

@NoArgsConstructor
@Getter @Setter
@ToString
public class User {

    private Integer id;
    private String firstName;
    private String lastName;

    public User(int id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
