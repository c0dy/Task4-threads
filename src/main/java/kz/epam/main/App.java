package kz.epam.main;

import kz.epam.seaport.Seaport;

public class App {
    public static void main(String[] args) throws InterruptedException {
        World world = World.getInstance();
        world.createShips(3);
        new Thread(new Seaport()).start();
    }
}
