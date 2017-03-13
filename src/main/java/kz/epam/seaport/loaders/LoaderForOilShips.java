package kz.epam.seaport.loaders;

import kz.epam.seaport.parkings.ParkingFactory;
import kz.epam.seaport.parkings.ParkingForOilShips;

import java.util.concurrent.TimeUnit;

public class LoaderForOilShips implements Runnable {
    private AbstractLoader loader = new AbstractLoader();
    private static ParkingFactory oilShips = new ParkingForOilShips();
    private volatile boolean isGone = false;

    @Override
    public void run() {
        while (!isGone) {
            try {
                Thread.sleep(8000); // Waiting for ships to arrive at the seaport
                while (oilShips.getSize() != 0) {
                    loader.fill(oilShips.takeShip());
                    isGone = true;
                    TimeUnit.MILLISECONDS.sleep(1500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
