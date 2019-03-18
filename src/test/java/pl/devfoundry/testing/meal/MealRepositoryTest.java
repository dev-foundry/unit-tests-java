package pl.devfoundry.testing.meal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.not;

class MealRepositoryTest {

    private MealRepository mealRepository = new MealRepository();

    @BeforeEach
    void cleanUp() {
        mealRepository.getAllMeals().clear();
    }

    @Test
    void shouldBeAbleToAddMealToRepository() {

        //given
        Meal meal = new Meal(10, "Pizza");

        //when
        mealRepository.add(meal);

        //then
        assertThat(mealRepository.getAllMeals().get(0), is(meal));

    }

    @Test
    void shouldBeAbleToFindMealByExactName() {

        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(10, "Pi");
        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> results = mealRepository.findByName("Pizza", true);

        //then
        assertThat(results.size(),is(1));

    }

    @Test
    void shouldBeAbleToFindMealByStartingLetters() {
        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(10, "Pi");
        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> results = mealRepository.findByName("P", false);

        //then
        assertThat(results.size(),is(2));
    }

    @Test
    void shouldBeAbleToFindMealByPrice() {
        //given
        Meal meal = new Meal(10, "Pizza");
        mealRepository.add(meal);

        //when
        List<Meal> results = mealRepository.findByPrice(10);

        //then
        assertThat(results.size(),is(1));
    }

    @Test
    void shouldBeAbleToRemoveMealFromRepository() {

        //given
        Meal meal = new Meal(10, "Pizza");
        mealRepository.add(meal);

        //when
        mealRepository.delete(meal);

        //then
        assertThat(mealRepository.getAllMeals(), not(contains(meal)));
    }
}
