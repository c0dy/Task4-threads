package kz.epam.main;


import kz.epam.seaport.Seaport;
import kz.epam.ships.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class World implements Runnable {
    private static final int QUANTITY = 3;
    private ArrayList<ShipFactory> ships = new ArrayList<>();
    private static volatile boolean isArrived = false;
    private Random rand = new Random(47);
    private Seaport seaport = new Seaport();

    public World() throws InterruptedException {
        addShips(QUANTITY);
    }

    private void addShips(int quantity) {
        System.out.println("--------------------WORLD----------------------");
        for(int i = 0; i < quantity; i++) {
            ShipWithCars carShip = new ShipWithCars(i, ShipType.CAR, rand.nextInt(100) + 1 * 10);
            ShipWithOils oilShip = new ShipWithOils(i, ShipType.OIL, rand.nextInt(1000) + 1 * 100);
            ShipWithContainers containerShip = new ShipWithContainers(i, ShipType.CONTAINER, rand.nextInt(100) + 1 * 100);
            ships.add(carShip);
            ships.add(oilShip);
            ships.add(containerShip);
        }
        for (ShipFactory s : ships) {
            System.out.println(s);
        }
        Collections.shuffle(ships); // pseudo-random
    }

    @Override
    public void run() {
        while (!isArrived) {
            try {
                System.out.println("\n-----------------SEAPORT---------------------");
                for (int i = 0; i < ships.size(); i++) {
                    seaport.arrived(ships.get(i));
                    TimeUnit.MILLISECONDS.sleep(1000);
                    isArrived = true;
                }
            } catch (InterruptedException e) {
                System.out.println("World interrupted" + e);
            }
        }
    }
}
