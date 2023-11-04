package com.codecool.kitchenmanagement;

import com.codecool.kitchenmanagement.models.Chef;
import com.codecool.kitchenmanagement.models.Cook;
import com.codecool.kitchenmanagement.models.Employee;
import com.codecool.kitchenmanagement.models.KitchenHelper;
import com.codecool.kitchenmanagement.models.ingredients.IngredientType;
import com.codecool.kitchenmanagement.models.ingredients.IngredientsStore;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Optional;

public class Kitchen implements IngredientsStore {
    @Getter
    private Chef chef;
    private ArrayList<Cook> cooks = new ArrayList<>();
    private ArrayList<KitchenHelper> helpers = new ArrayList<>();

    public Kitchen() {
    }

    @Override
    public Optional<IngredientType> requestIngredient(IngredientType ingredientType) {
        for (KitchenHelper helper : helpers) {
            if (helper.hasIngredient(ingredientType)) {
                return helper.giveIngredient(ingredientType);
            }
        }

        System.out.println("We are all out");

        return Optional.empty();
    }

    public void startShift() {
        if (this.getChef() == null) {
            throw new IllegalArgumentException("No chef on shift");
        }

        helpers.forEach(KitchenHelper::addIngredients);
        cooks.forEach(Cook::cook);
        chef.cook();
    }

    public void hireEmployee(Employee employee) {
        if (employee instanceof Cook cook) {
            cooks.add(cook);
        }

        if (employee instanceof KitchenHelper kitchenHelper) {
            helpers.add(kitchenHelper);
        }

        if (employee instanceof Chef chef) {
            hireChef(chef);
        }
    }

    private void hireChef(Chef chef) {
        if (this.getChef() != null) {
            fireChef();
        }

        this.chef = chef;
        this.chef.setIngredientsStore(this);
    }

    private void fireChef() {
        this.chef = null;
    }
}
