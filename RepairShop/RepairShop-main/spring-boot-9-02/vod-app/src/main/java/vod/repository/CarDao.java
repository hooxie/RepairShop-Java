package vod.repository;

import vod.model.Car;
import vod.model.Mechanic;
import vod.model.RepairShop;

import java.util.List;

public interface CarDao {
    List<Car> findAll();
    Car findById(int id);
    List<Car> findByMechanic(Mechanic m);
    List<Car> findByRepairShop(RepairShop rs);
    Car add(Car c);
}
