package kz.epam.main;


import kz.epam.seaport.Parking;
import kz.epam.seaport.Seaport;

public class App {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Parking()).start();
        new Thread(new Seaport()).start();
        new Thread(new World()).start();
    }
}
