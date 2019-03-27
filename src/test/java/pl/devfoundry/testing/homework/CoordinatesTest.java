package pl.devfoundry.testing.homework;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoordinatesTest {


    @Test
    void constructorShouldFailIfAnyValueAbove100() {

        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(101, 0));
    }

    @Test
    void constructorShouldFailIfAnyValueBelow0() {

        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(-1, 0));
    }

    @Test
    void copyShouldReturnNewObject() {
        //given
        Coordinates coordinates = new Coordinates(10,10);

        //when
        Coordinates copy = Coordinates.copy(coordinates, 0, 0);

        //then
        assertThat(copy, not(sameInstance(coordinates)));
        assertThat(copy, equalTo(coordinates));
    }

    @Test
    void copyShouldReturnAddCoordinates() {
        //given
        Coordinates coordinates = new Coordinates(10,10);

        //when
        Coordinates copy = Coordinates.copy(coordinates, 5, 6);

        //then
        assertThat(copy.getX(), equalTo(15));
        assertThat(copy.getY(), equalTo(16));

    }
}
