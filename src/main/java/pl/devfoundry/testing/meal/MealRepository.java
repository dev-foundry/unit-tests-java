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

    public List<Meal> find(String name, boolean exactName, int price, SearchType priceSearchType) {

        List<Meal> nameMatches = findByName(name, exactName);

        List<Meal> result = findByPriceWithInitialData(price, priceSearchType, nameMatches);

        return result;

    }

    private List<Meal> findByPriceWithInitialData(int price, SearchType type, List<Meal> initialData) {
        List<Meal> result = new ArrayList<>();

        switch (type) {
            case Exact:
                result = initialData.stream()
                        .filter(meal -> meal.getPrice() == price)
                        .collect(Collectors.toList());
                break;
            case Less:
                result = initialData.stream()
                        .filter(meal -> meal.getPrice() < price)
                        .collect(Collectors.toList());
                break;
            case More:
                result = initialData.stream()
                        .filter(meal -> meal.getPrice() > price)
                        .collect(Collectors.toList());
                break;

        }

        return result;
    }

    public List<Meal> findByName(String mealName, boolean exactMatch) {

        List<Meal> result;

        if (exactMatch) {
            result = meals.stream()
                    .filter(meal -> meal.getName().equals(mealName))
                    .collect(Collectors.toList());
        } else {
            result = meals.stream()
                    .filter(meal -> meal.getName().startsWith(mealName))
                    .collect(Collectors.toList());
        }

        return result;

    }

    public List<Meal> findByPrice(int price, SearchType type) {

        return findByPriceWithInitialData(price, type, meals);

    }
}
