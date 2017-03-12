package kz.epam.seaport;

import kz.epam.ships.ShipFactory;
import kz.epam.ships.ShipType;
import java.util.concurrent.LinkedBlockingQueue;

public class ParkingForOilShips extends ParkingFactory {
    private LinkedBlockingQueue<ShipFactory> parking = new LinkedBlockingQueue<>();

    @Override
    public synchronized void parked(ShipFactory ship) throws InterruptedException {
        parking.put(ship);
        System.out.println(parking.take().toString() + toString() + " OIL");
    }

    @Override
    public ShipType getType() {
        return parking.peek().getType();
    }
}
