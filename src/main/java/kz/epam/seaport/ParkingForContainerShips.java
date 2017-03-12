package kz.epam.seaport;


import kz.epam.ships.ShipFactory;
import kz.epam.ships.ShipType;
import java.util.concurrent.LinkedBlockingQueue;

public class ParkingForContainerShips extends ParkingFactory {
    private LinkedBlockingQueue<ShipFactory> parking = new LinkedBlockingQueue<>();

    @Override
    public void parked(ShipFactory ship) throws InterruptedException {
        parking.put(ship);
        System.out.println(parking.take().toString() + toString() + " CONTAINER");
    }

    @Override
    public ShipType getType() {
       return parking.peek().getType();
    }
}
