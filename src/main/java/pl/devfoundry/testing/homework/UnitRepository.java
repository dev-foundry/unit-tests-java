package pl.devfoundry.testing.homework;

import java.util.HashMap;
import java.util.Map;

public class UnitRepository {

    private Map<Coordinates, Unit> units;

    UnitRepository() {
        units = new HashMap<>();
    }

    void addUnit(Unit unit) {
        units.put(unit.getCoordinates(), unit);
    }

    void removeUnit(Unit unit) {
        units.remove(unit.getCoordinates());
    }

    void removeUnit(Coordinates coordinates) {
        units.remove(coordinates);
    }

    Unit getUnitByCoordinates(Coordinates coordinates) {
        return units.get(coordinates);
    }

}