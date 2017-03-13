package kz.epam.seaport;

import kz.epam.main.World;
import kz.epam.seaport.parkings.ParkingFactory;
import kz.epam.seaport.parkings.ParkingForCarShips;
import kz.epam.seaport.parkings.ParkingForContainerShips;
import kz.epam.seaport.parkings.ParkingForOilShips;
import kz.epam.ships.ShipFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Seaport implements Runnable {
    private static final String ARRIVED = " <--{ Arrived at the Seaport }";
    private static final String SEAPORT = "\n-----------------SEAPORT---------------------";
    private static LinkedBlockingQueue<ShipFactory> ships = new LinkedBlockingQueue<>();
    private ParkingFactory parkingForContainerShips = new ParkingForContainerShips();
    private ParkingFactory parkingForOilShips = new ParkingForOilShips();
    private ParkingFactory parkingForCarShips = new ParkingForCarShips();
    private volatile boolean isArrived = false;
    private World world = World.getInstance();

    @Override
    public void run() {
        while (!isArrived) {
            try {
                System.out.println(SEAPORT);
                for (int i = 0; i < world.getShips().size(); i++) {
                    ships.put(world.getShips().get(i));
                    System.out.println(ships.peek().toString() + ARRIVED);

                    switch (ships.peek().getType()) {
                        case OIL:
                            System.out.println(ships.peek().toString() + parkingForOilShips.toString());
                            parkingForOilShips.parked(ships.take());
                            break;
                        case CONTAINER:
                            System.out.println(ships.peek().toString() + parkingForContainerShips.toString());
                            parkingForContainerShips.parked(ships.take());
                            break;
                        case CAR:
                            System.out.println(ships.peek().toString() + parkingForCarShips.toString());
                            parkingForCarShips.parked(ships.take());
                            break;
                        default:
                            break;
                    }
                    TimeUnit.MILLISECONDS.sleep(500);
                    isArrived = true;
                }
            } catch (InterruptedException e) {
                System.out.println("Seaport interrupted" + e);
            }
        }
    }
}
