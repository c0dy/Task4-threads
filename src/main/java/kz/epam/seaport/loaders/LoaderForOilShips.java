package kz.epam.seaport.loaders;

import kz.epam.seaport.parkings.ParkingForOilShips;

public class LoaderForOilShips implements Runnable {
    private AbstractLoader loader = new AbstractLoader();
    private static ParkingForOilShips oilShips = new ParkingForOilShips();
    private volatile boolean isGone = false;

    @Override
    public void run() {
        while (!isGone) {
            try {
                Thread.sleep(8000);
                while (oilShips.getSize() > 0) {
                    Thread.sleep(1500);
                    System.out.println(oilShips.peekShip() + loader.toString());
                    loader.fill(oilShips.takeShip());
                    Thread.sleep(1000);
                }
                isGone = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
