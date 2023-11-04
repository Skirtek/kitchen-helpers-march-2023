package com.codecool.kitchenmanagement.models;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Employee {
    private String name;
    private LocalDate birthDate;
    private int salary;

    public void printTax() {
        double tax = salary * 0.99;

        System.out.println("My tax is: " + tax);
    }
}
