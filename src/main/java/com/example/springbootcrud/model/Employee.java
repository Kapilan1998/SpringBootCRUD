package com.example.springbootcrud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter     //@Getter lambok annotation for getter method for below private variable
@Setter     //@Setter lambok annotation for setter method for below private variable
@NoArgsConstructor      //default constructor with no argument
@AllArgsConstructor
@Entity         // Employee class is entity
@Table(name ="employee")
public class Employee {

    @Id  //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY )    //primary key generate as auto increment
    private long id;
    @Column(name = "first_name",nullable = false)   //set column name in DB
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "email_id",nullable = false)
    private String emailID;

}
