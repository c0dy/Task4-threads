package kz.epam.seaport.loaders;

import kz.epam.seaport.parkings.ParkingFactory;
import kz.epam.seaport.parkings.ParkingForContainerShips;

import java.util.concurrent.TimeUnit;

public class LoaderForContainerShips implements Runnable {
    private AbstractLoader loader = new AbstractLoader();
    private static ParkingFactory containerShips = new ParkingForContainerShips();
    private volatile boolean isGone = false;

    @Override
    public void run() {
        while (!isGone) {
            try {
                Thread.sleep(8000); // Waiting for ships to arrive at the seaport
                while (containerShips.getSize() != 0) {
                    loader.fill(containerShips.takeShip());
                    isGone = true;
                    TimeUnit.MILLISECONDS.sleep(1500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
