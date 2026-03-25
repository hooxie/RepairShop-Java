package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.Car;
import vod.model.Mechanic;
import vod.model.RepairShop;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {

    List<Car> findAllByMechanic(Mechanic m);


    List<Car> findAllByRepairShopsContaining(RepairShop rs);
}