package kz.epam.seaport.loaders;

import kz.epam.seaport.parkings.ParkingFactory;
import kz.epam.seaport.parkings.ParkingForCarShips;

import java.util.concurrent.TimeUnit;

public class LoaderForCarShips implements Runnable {
    private AbstractLoader loader = new AbstractLoader();
    private static ParkingFactory carShips = new ParkingForCarShips();
    private volatile boolean isGone = false;

    @Override
    public void run() {
        while (!isGone) {
            try {
                Thread.sleep(8000); // Waiting for ships to arrive at the seaport
                while (carShips.getSize() != 0) {
                    loader.fill(carShips.takeShip());
                    isGone = true;
                    TimeUnit.MILLISECONDS.sleep(1500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
