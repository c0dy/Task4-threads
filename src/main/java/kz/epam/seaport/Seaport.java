package kz.epam.seaport;


import kz.epam.main.World;
import kz.epam.ships.ShipFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Seaport implements Runnable {
    private static final String ARRIVED = " <--{ Arrived at the Seaport }";
    private LinkedBlockingQueue<ShipFactory> port = new LinkedBlockingQueue<>();
    private volatile boolean isArrived = false;
    private ParkingFactory parkingForOilShips = new ParkingForOilShips();
    private ParkingFactory parkingForCarShips = new ParkingForCarShips();
    private ParkingFactory parkingForContainerShips = new ParkingForContainerShips();
    private World world = World.getInstance();

    public LinkedBlockingQueue<ShipFactory> getPort() {
        return port;
    }

    public void setPort(LinkedBlockingQueue<ShipFactory> port) {
        this.port = port;
    }

    @Override
    public void run() {
        while (!isArrived) {
            try {
                System.out.println("\n-----------------SEAPORT---------------------");
                for (int i = 0; i < world.getShips().size(); i++) {
                    port.put(world.getShips().get(i));
                    System.out.println(port.peek().toString() + ARRIVED);
                    switch (port.peek().getType()) {
                        case OIL:
                            parkingForOilShips.parked(port.take());
                            break;
                        case CONTAINER:
                            parkingForContainerShips.parked(port.take());
                            break;
                        case CAR:
                            parkingForCarShips.parked(port.take());
                            break;
                        default:
                            break;
                    }
                    TimeUnit.MILLISECONDS.sleep(1000);
                    isArrived = true;
                }
            } catch (InterruptedException e) {
                System.out.println("Seaport interrupted" + e);
            }
        }
    }
}
