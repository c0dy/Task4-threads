package kz.epam.seaport;


import kz.epam.ships.ShipFactory;
import kz.epam.ships.ShipType;
import java.util.concurrent.LinkedBlockingQueue;

public class Parking extends ParkingFactory implements Runnable {
    private LinkedBlockingQueue<ShipFactory> parking = new LinkedBlockingQueue<>();
    private static final String PARKED = " <--{ parked on ";

    public Parking(ShipType type) {
        super(type);
    }

    public Parking() {}

    @Override
    public synchronized void parked(ShipFactory ship) {
        /*try {
            switch (ship.getType()) {
                case OIL:
                    parking.put(ship);
                    System.out.println(parking.take().toString() + PARKED + getType());
                    break;
                case CAR:
                    parking.put(ship);
                    System.out.println(parking.take().toString() + PARKED + getType());
                    break;
                case CONTAINER:
                    parking.put(ship);
                    System.out.println(parking.take().toString() + PARKED + getType());
                    break;
                default:
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("HI");
    }

    @Override
    public void run() {

    }
}
