package pl.devfoundry.testing.meal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.not;

public class MealRepositoryTest {

    MealRepository mealRepository = new MealRepository();

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
    void shouldBeAbleToFindMealByName() {

        //given
        Meal meal = new Meal(10, "Pizza");
        mealRepository.add(meal);

        //when
        List<Meal> results = mealRepository.findByName("Pizza", Comp.EQUALS);

        //then
        assertThat(results.size(),is(1));

    }

    @Test
    void shouldBeAbleToFindMealByNameLike() {

        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(10, "Pzza");
        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> results = mealRepository.findByName("Pi", Comp.LIKE);

        //then
        assertThat(results.size(),is(1));

    }

    @Test
    void shouldBeAbleToFindMealByEqualPrice() {
        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(15, "Hamburger");
        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> results = mealRepository.findByPrice(10, Comp.EQUALS);

        //then
        assertThat(results.size(),is(1));
        assertThat(results.get(0).getName(), is("Pizza"));
    }

    @Test
    void shouldBeAbleToFindMealByLessPrice() {
        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(15, "Hamburger");
        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> results = mealRepository.findByPrice(11, Comp.LESS);

        //then
        assertThat(results.size(),is(1));
        assertThat(results.get(0).getName(), is("Pizza"));
    }

    @Test
    void shouldBeAbleToFindMealByGreaterPrice() {
        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(15, "Hamburger");
        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> results = mealRepository.findByPrice(11, Comp.GREATER);

        //then
        assertThat(results.size(),is(1));
        assertThat(results.get(0).getName(), is("Hamburger"));
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
