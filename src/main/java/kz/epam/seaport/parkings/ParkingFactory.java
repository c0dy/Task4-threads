package kz.epam.seaport.parkings;

import kz.epam.ships.ShipFactory;

public abstract class ParkingFactory {

    public abstract void parked(ShipFactory ship) throws InterruptedException;

    public abstract ShipFactory peekShip() throws InterruptedException;

    public abstract ShipFactory takeShip() throws InterruptedException;

    public abstract int getSize();

    @Override
    public String toString() {
        return  " <--{ parked in a " + this.getClass().getSimpleName() + " }";
    }
}
