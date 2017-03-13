package kz.epam.seaport.parkings;

import kz.epam.ships.ShipFactory;
import java.util.concurrent.LinkedBlockingQueue;

public class ParkingForOilShips extends ParkingFactory {
    private static LinkedBlockingQueue<ShipFactory> ships = new LinkedBlockingQueue<>();

    @Override
    public synchronized void parked(ShipFactory ship) throws InterruptedException {
        ships.put(ship);
    }

    @Override
    public synchronized ShipFactory peekShip() throws InterruptedException {
        return ships.peek();
    }

    @Override
    public synchronized ShipFactory takeShip() throws InterruptedException {
        return ships.take();
    }

    @Override
    public synchronized int getSize() {
        return ships.size();
    }
}
