package kz.epam.seaport;

import kz.epam.ships.ShipFactory;
import kz.epam.ships.ShipType;

public abstract class ParkingFactory {

    public abstract void parked(ShipFactory ship) throws InterruptedException;

    public abstract ShipType getType();

    @Override
    public String toString() {
        return  " <--{ parked in a parking lot for " + /*getType() +*/ " ships }";
    }
}
