package kz.epam.main;

import kz.epam.seaport.*;
import kz.epam.seaport.loaders.LoaderForCarShips;
import kz.epam.seaport.loaders.LoaderForContainerShips;
import kz.epam.seaport.loaders.LoaderForOilShips;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws InterruptedException {
        World world = World.getInstance();
        world.createShips(7);
        new Thread(new Seaport()).start();
        ExecutorService execForContainerShips = Executors.newFixedThreadPool(2);
        ExecutorService execForOilShips = Executors.newFixedThreadPool(2);
        ExecutorService execForCarShips = Executors.newFixedThreadPool(2);
        execForOilShips.execute(new LoaderForOilShips());
        execForOilShips.execute(new LoaderForOilShips());
        execForCarShips.execute(new LoaderForCarShips());
        execForCarShips.execute(new LoaderForCarShips());
        execForContainerShips.execute(new LoaderForContainerShips());
        execForContainerShips.execute(new LoaderForContainerShips());

        execForContainerShips.shutdown();
        execForOilShips.shutdown();
        execForCarShips.shutdown();
    }
}
