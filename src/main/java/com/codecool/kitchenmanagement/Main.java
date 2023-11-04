package com.codecool.kitchenmanagement;

import com.codecool.kitchenmanagement.models.Chef;
import com.codecool.kitchenmanagement.models.Cook;
import com.codecool.kitchenmanagement.models.Employee;
import com.codecool.kitchenmanagement.models.KitchenHelper;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();

        LocalDate hireDate = LocalDate.now();

        Chef chef = new Chef("Paweł", hireDate, 2345);
        chef.giveKnife();

        Cook cook = new Cook("Jan", hireDate, 1350);
        cook.giveKnife();

        Cook anotherCook = new Cook("Przemysław", hireDate, 1211);

        KitchenHelper firstHelper = new KitchenHelper("Michał", hireDate, 900);
        KitchenHelper secondHelper = new KitchenHelper("Michał", hireDate, 800);
        KitchenHelper thirdHelper = new KitchenHelper("Michał", hireDate, 700);

        List<Employee> employeeList = List.of(chef, cook, anotherCook, firstHelper, secondHelper, thirdHelper);

        employeeList.forEach(kitchen::hireEmployee);

        kitchen.startShift();
    }
}
