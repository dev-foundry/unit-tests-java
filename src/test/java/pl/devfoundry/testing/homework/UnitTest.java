package pl.devfoundry.testing.homework;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UnitTest {


    @Test
    void unitShouldNotMoveWithoutFuel() {

        //given
        Unit unit = new Unit(new Coordinates(0,0),0,10);

        //when
        //then
        assertThrows(IllegalStateException.class, () -> unit.move(2,2));
    }

    @Test
    void unitShouldLoseFuelWhenMoving() {

        //given
        Unit unit = new Unit(new Coordinates(0,0),10,10);

        //when
        unit.move(2,2);

        //then
        assertThat(unit.getFuel(), is(6));
    }

    @Test
    void movedUnitShouldReturnNewCoordinates() {

        //given
        Unit unit = new Unit(new Coordinates(0,0),10,10);

        //when
        Coordinates move = unit.move(2, 2);

        //then
        assertThat(move, equalTo(new Coordinates(2,2)));
    }

    @Test
    void fuelingShouldNotExceedMaxFuelLimit() {
        //given
        Unit unit = new Unit(new Coordinates(0,0),10,10);

        //when
        unit.tankUp();

        //then
        assertThat(unit.getFuel(), is(10));
    }

    @Test
    void cargoCanNotExceedMaxWeightLimit() {
        //given
        Unit unit = new Unit(new Coordinates(0,0),10,10);

        Cargo c1 = new Cargo("c1", 5);
        Cargo c2 = new Cargo("c2", 6);

        //when
        unit.loadCargo(c1);

        //then
        assertThrows(IllegalStateException.class, () -> unit.loadCargo(c2));
    }

    @Test
    void unloadingAllCargoShouldReduceUnitLoadToZero() {
        //given
        Unit unit = new Unit(new Coordinates(0,0),10,10);

        Cargo c1 = new Cargo("c1", 5);
        Cargo c2 = new Cargo("c2", 5);

        unit.loadCargo(c1);
        unit.loadCargo(c2);

        //when
        unit.unloadAllCargo();

        //then
        assertThat(unit.getLoad(), is(0));
    }


}
