package vod.service;

import vod.model.Mechanic;
import vod.model.Car;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    List<Car> getCarsByMechanic(Mechanic m);

    Car getCarById(int id);

    Car addCar(Car c);

    List<Mechanic> getAllMechanics();

    Mechanic getMechanicById(int id);

    Mechanic addMechanic(Mechanic m);
}
