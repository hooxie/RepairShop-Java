package vod.repository.mem;

import vod.model.RepairShop;
import vod.model.Mechanic;
import vod.model.Car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SampleData {

    static List<RepairShop> repairShops = new ArrayList<>();
    static List<Mechanic> mechanics = new ArrayList<>();
    static List<Car> cars = new ArrayList<>();

    static {
        // Mechanicy (odpowiednik reżyserów)
        Mechanic m1 = new Mechanic(1, "Jan", "Kowalski");
        Mechanic m2 = new Mechanic(2, "Piotr", "Nowak");
        Mechanic m3 = new Mechanic(3, "Adam", "Wiśniewski");

        mechanics.add(m1);
        mechanics.add(m2);
        mechanics.add(m3);

        // Samochody (odpowiednik filmów)
        Car c1 = new Car(1, "Toyota", "Yaris");
        c1.setMechanic(m1);

        Car c2 = new Car(2, "Ford", "Focus");
        c2.setMechanic(m2);

        Car c3 = new Car(3, "BMW", "Seria 3");
        c3.setMechanic(m1);

        Car c4 = new Car(4, "Audi", "A4");
        c4.setMechanic(m3);

        Car c5 = new Car(5, "Skoda", "Octavia");
        c5.setMechanic(m2);

        cars.add(c1);
        cars.add(c2);
        cars.add(c3);
        cars.add(c4);
        cars.add(c5);

        // Warsztaty (odpowiednik kin)
        RepairShop rs1 = new RepairShop(1, "Auto-Fix Centrum", "ul. Mechaniczna 1, Warszawa");
        RepairShop rs2 = new RepairShop(2, "Szybki Serwis Nowak", "ul. Naprawcza 15, Kraków");
        RepairShop rs3 = new RepairShop(3, "Moto-Klinika", "ul. Olejowa 7, Poznań");

        repairShops.add(rs1);
        repairShops.add(rs2);
        repairShops.add(rs3);

        // Powiązania: w jakich warsztatach było auto (relacja wiele do wielu - odpowiednik metody bind)
        bind(rs1, c1);
        bind(rs1, c3);
        bind(rs2, c2);
        bind(rs2, c5);
        bind(rs3, c4);
        bind(rs3, c1); // Yaris był w dwóch warsztatach
    }

    private static void bind(RepairShop rs, Car c) {
        rs.addCar(c);
        c.addRepairShop(rs);
    }
}