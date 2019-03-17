package pl.devfoundry.testing.meal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MealRepository {

    private List<Meal> meals = new ArrayList<>();

    public void add(Meal meal) {
        meals.add(meal);
    }

    public List<Meal> getAllMeals() {
        return meals;
    }

    public void delete(Meal meal) {
        meals.remove(meal);
    }

    public List<Meal> findByName(String mealName, Comp like) {

        switch (like) {
            case EQUALS:
                return meals.stream()
                        .filter(meal -> meal.getName().equals(mealName))
                        .collect(Collectors.toList());
            case LIKE:
                return meals.stream()
                        .filter(meal -> meal.getName().startsWith(mealName))
                        .collect(Collectors.toList());
            default:
                return new ArrayList<>();
        }


    }

    public List<Meal> findByPrice(int price, Comp comparsion) {

        switch (comparsion) {
            case EQUALS:
                return meals.stream()
                        .filter(meal -> meal.getPrice() == price)
                        .collect(Collectors.toList());
            case LESS:
                return meals.stream()
                        .filter(meal -> meal.getPrice() < price)
                        .collect(Collectors.toList());
            case GREATER:
                return meals.stream()
                        .filter(meal -> meal.getPrice() > price)
                        .collect(Collectors.toList());

            default:
                return new ArrayList<>();
        }


    }
}
