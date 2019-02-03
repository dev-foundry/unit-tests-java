package pl.devfoundry.testing;

import java.util.ArrayList;
import java.util.List;

class Order {

    private List<Meal> meals = new ArrayList<>();

    void addMealToOrder(Meal meal) {
        this.meals.add(meal);
    }

    void removeMealFromOrder(Meal meal) {
        this.meals.remove(meal);
    }

    List<Meal> getMeals() {
        return meals;
    }

    void cancel() {
        this.meals.clear();
    }

}
