package pl.devfoundry.testing.homework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UnitServiceTest {

    @Mock
    private CargoRepository cargoRepository;

    @Mock
    private UnitRepository unitRepository;

    @InjectMocks
    private UnitService unitService;


    @Test
    void addedCargoShouldBeLoadedOnUnit() {

        //given
        Unit unit = new Unit(new Coordinates(0, 0), 10, 10);
        Cargo cargo = new Cargo("package", 5);

        given(cargoRepository.findCargoByName("package")).willReturn(Optional.of(cargo));

        //when
        unitService.addCargoByName(unit, "package");

        //then
        verify(cargoRepository).findCargoByName("package");
        assertThat(unit.getLoad(), is(5));
        assertThat(unit.getCargo().get(0), equalTo(cargo));

    }

    @Test
    void shouldThrowExceptionIfNoCargoIsFoundToAdd() {
        //given
        Unit unit = new Unit(new Coordinates(0, 0), 10, 10);

        given(cargoRepository.findCargoByName("package")).willReturn(Optional.empty());

        //when
        //then
        assertThrows(NoSuchElementException.class, () -> unitService.addCargoByName(unit, "package"));

    }

    @Test
    void shouldReturnUnitByCoordinates() {

        //given
        Unit unit = new Unit(new Coordinates(0, 0), 10, 10);

        given(unitRepository.getUnitByCoordinates(new Coordinates(0, 0))).willReturn(unit);

        //when
        Unit result = unitService.getUnitOn(new Coordinates(0, 0));

        //then
        assertThat(result, sameInstance(unit));
    }

    @Test
    void shouldReturnExceptionIfUnitNotFound() {
        //given
        given(unitRepository.getUnitByCoordinates(new Coordinates(0, 0))).willReturn(null);

        //when
        //then
        assertThrows(NoSuchElementException.class, () -> unitService.getUnitOn(new Coordinates(0, 0)));
    }

}
