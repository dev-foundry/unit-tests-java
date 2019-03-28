package pl.devfoundry.testing.homework;

import java.util.NoSuchElementException;
import java.util.Optional;

public class UnitService {

    private CargoRepository cargoRepository = new CargoRepository();
    private UnitRepository unitRepository = new UnitRepository();

    void addCargoByName(Unit unit, String name) {

        Optional<Cargo> cargo = cargoRepository.findCargoByName(name);

        if (cargo.isPresent()) {
            unit.loadCargo(cargo.get());
        } else {
            throw new NoSuchElementException("Unable to find cargo");
        }
    }

    Unit getUnitOn(Coordinates coordinates) {

        Unit u = unitRepository.getUnitByCoordinates(coordinates);

        if (u == null) {
            throw new NoSuchElementException("Unable to find any unit");
        } else {
            return u;
        }
    }

}