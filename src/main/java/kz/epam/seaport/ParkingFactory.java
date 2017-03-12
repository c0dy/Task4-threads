package kz.epam.seaport;


import kz.epam.ships.ShipFactory;
import kz.epam.ships.ShipType;

public abstract class ParkingFactory {
    private ShipType type;

    public ParkingFactory(ShipType type) {
        this.type = type;
    }

    public ParkingFactory() {}

    public abstract void parked(ShipFactory ship);

    public ShipType getType() {
        return type;
    }

    public void setType(ShipType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Parking for: " + type;
    }
}
