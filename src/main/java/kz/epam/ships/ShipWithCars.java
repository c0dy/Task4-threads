package kz.epam.ships;


import kz.epam.ships.cargo.Car;
import kz.epam.ships.cargo.Cargo;
import java.util.ArrayList;

public class ShipWithCars extends ShipFactory {
    private ArrayList<Cargo> cargo = new ArrayList<Cargo>(getVolume());
    private Cargo car = new Car();

    public ShipWithCars(int name, ShipType type, int volume) {
        super(name, ShipType.CAR, volume);
    }

    public synchronized void addCargo() {
        cargo.add(car);
    }

    @Override
    public String toString() {
        return "Ship: " + getName() + " , type: " + getType() + " , volume: " + getVolume() + " cars";
    }
}
