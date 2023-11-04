package com.codecool.kitchenmanagement.models;

import com.codecool.kitchenmanagement.interfaces.Cooking;

import java.time.LocalDate;

public class Cook extends Employee implements Cooking {
    private boolean hasKnife;

    public Cook(String name, LocalDate birthDate, int salary) {
        super(name, birthDate, salary);
    }

    @Override
    public void cook() {
        if (!this.hasKnife) {
            System.out.println("I'm " + this.getName() + " and I can not cook without knife");
            return;
        }

        System.out.println("I'm cooking Chef!");
    }

    @Override
    public void giveKnife() {
        this.hasKnife = true;
    }
}
