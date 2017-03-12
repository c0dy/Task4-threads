package kz.epam.main;


import kz.epam.ships.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class World {
    private List<ShipFactory> ships = Collections.synchronizedList(new ArrayList<ShipFactory>());
    private Random rand = new Random(47);
    private static World world;

    private World() {}

    public static World getInstance() {
        if (world == null)
            world = new World();
        return world;
    }

    public List<ShipFactory> getShips() {
        return ships;
    }

    public void setShips(List<ShipFactory> ships) {
        this.ships = ships;
    }

    public void createShips(int quantity) {
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
}
