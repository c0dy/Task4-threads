package kz.epam.seaport.loaders;

import kz.epam.ships.ShipFactory;

public class AbstractLoader {
    public synchronized void fill(ShipFactory ship) {
        for (int i = 0; i < ship.getVolume(); i++) {
            ship.addCargo();
        }
    }

    @Override
    public String toString() {
        return " <--{The cargo is loaded on the ship, and the ship is gone}";
    }
}
