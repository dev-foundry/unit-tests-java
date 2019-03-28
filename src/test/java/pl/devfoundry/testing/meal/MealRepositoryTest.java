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
    void shouldBeAbleToFindMealByExactPrice() {
        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(9, "Burger");

        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> results = mealRepository.findByPrice(10, SearchType.Exact);

        //then
        assertThat(results.size(),is(1));
        assertThat(results.get(0), is(meal));
    }

    @Test
    void shouldBeAbleToFindMealByLesserPrice() {
        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(9, "Burger");

        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> results = mealRepository.findByPrice(10, SearchType.Less);

        //then
        assertThat(results.size(),is(1));
        assertThat(results.get(0), is(meal2));
    }

    @Test
    void shouldBeAbleToFindMealByHigherPrice() {
        //given
        Meal meal = new Meal(11, "Pizza");
        Meal meal2 = new Meal(9, "Burger");

        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> results = mealRepository.findByPrice(10, SearchType.More);

        //then
        assertThat(results.size(),is(1));
        assertThat(results.get(0), is(meal));
    }

    @Test
    void shouldFindByExactNameAndExactPrice() {
        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(9, "Burger");

        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> results = mealRepository.find("Pizza", true, 10, SearchType.Exact);

        //then
        assertThat(results.size(),is(1));
        assertThat(results.get(0), is(meal));
    }

    @Test
    void shouldFindByFirstLetterAndExactPrice() {
        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(9, "Burger");

        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> results = mealRepository.find("B", false, 9, SearchType.Exact);

        //then
        assertThat(results.size(),is(1));
        assertThat(results.get(0), is(meal2));
    }

    @Test
    void shouldFindByExactNameAndLowerPrice() {
        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(9, "Burger");

        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> results = mealRepository.find("Pizza", true, 11, SearchType.Less);

        //then
        assertThat(results.size(),is(1));
        assertThat(results.get(0), is(meal));
    }

    @Test
    void shouldFindByFirstLetterAndLowerPrice() {
        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(9, "Burger");

        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> results = mealRepository.find("B", false, 10, SearchType.Less);

        //then
        assertThat(results.size(),is(1));
        assertThat(results.get(0), is(meal2));
    }

    @Test
    void shouldFindByExactNameAndHigherPrice() {
        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(9, "Burger");

        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> results = mealRepository.find("Pizza", true, 9, SearchType.More);

        //then
        assertThat(results.size(),is(1));
        assertThat(results.get(0), is(meal));
    }

    @Test
    void shouldFindByFirstLetterAndHigherPrice() {
        //given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(9, "Burger");

        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> results = mealRepository.find("B", false, 8, SearchType.More);

        //then
        assertThat(results.size(),is(1));
        assertThat(results.get(0), is(meal2));
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
