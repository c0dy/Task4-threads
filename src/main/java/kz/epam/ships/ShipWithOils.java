package kz.epam.ships;

import kz.epam.ships.cargo.Cargo;
import kz.epam.ships.cargo.Oil;
import java.util.ArrayList;

public class ShipWithOils extends ShipFactory {
    private ArrayList<Cargo> cargo = new ArrayList<Cargo>(getVolume());
    private Cargo oil = new Oil();

    public ShipWithOils(int name, ShipType type, int volume) {
        super(name, ShipType.OIL, volume);
    }

    public synchronized void addCargo() {
        cargo.add(oil);
    }

    @Override
    public String toString() {
        return "Ship: " + getName() + " , type: " + getType() + " , volume: " + getVolume() + " liters";
    }
}
