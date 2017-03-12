package kz.epam.ships;


import kz.epam.ships.cargo.Cargo;
import kz.epam.ships.cargo.Container;
import java.util.ArrayList;


public class ShipWithContainers extends ShipFactory {
    private ArrayList<Cargo> cargo = new ArrayList<Cargo>(getVolume());
    private Cargo container = new Container();

    public ShipWithContainers(int name, ShipType type, int volume) {
        super(name, ShipType.CONTAINER, volume);
    }

    public synchronized void addCargo() {
        cargo.add(container);
    }

    @Override
    public String toString() {
        return "Ship: " + getName() + " , type: " + getType() + " , volume: " + getVolume() + " containers";
    }
}
