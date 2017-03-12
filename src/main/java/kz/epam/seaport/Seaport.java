package kz.epam.seaport;


import kz.epam.ships.ShipFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Seaport implements Runnable {
    private LinkedBlockingQueue<ShipFactory> port = new LinkedBlockingQueue<>();
    private LinkedBlockingQueue<ShipFactory> ppp = new LinkedBlockingQueue<>();
    private static final String ARRIVED = " <--{ Arrived at the Seaport }";
    private volatile boolean isParked = false;
    private ParkingFactory parking = new Parking();

    public synchronized void arrived(ShipFactory ship) throws InterruptedException {
        port.put(ship);
        ppp.put(port.peek());
        System.out.println(port.take().toString() + ARRIVED);
        System.out.println(ppp.size());
    }

    @Override
    public void run() {
        while (!isParked) {
            try {
                System.out.println("HI");
                for (int i = 0; i < ppp.size(); i++) {
                    System.out.println("HI");
                    TimeUnit.MILLISECONDS.sleep(5000);
                }
                isParked = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
