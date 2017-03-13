package kz.epam.main;

import kz.epam.seaport.*;
import kz.epam.seaport.loaders.LoaderForOilShips;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws InterruptedException {
        World world = World.getInstance();
        world.createShips(7);
        ExecutorService exec = Executors.newFixedThreadPool(2);
        exec.execute(new Seaport());
        exec.execute(new LoaderForOilShips());
        exec.execute(new LoaderForOilShips());
        exec.shutdown();
    }
}
