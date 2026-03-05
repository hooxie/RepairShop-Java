package vod.repository.mem;

import org.springframework.stereotype.Component;
import vod.repository.CarDao;
import vod.model.RepairShop;
import vod.model.Mechanic;
import vod.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemCarDao implements CarDao {
    @Override
    public List<Car> findAll() {
        return SampleData.cars;
    }

    @Override
    public Car findById(int id) {
        return SampleData.cars.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Car> findByMechanic(Mechanic m) {
        return SampleData.cars.stream().filter(c -> c.getMechanic() == m).collect(Collectors.toList());
    }

    @Override
    public List<Car> findByRepairShop(RepairShop rs) {
        return SampleData.cars.stream().filter(c -> c.getRepairShops().contains(rs)).collect(Collectors.toList());
    }

    @Override
    public Car add(Car c) {
        int max = SampleData.cars.stream().mapToInt(Car::getId).max().orElse(0);
        c.setId(++max);
        SampleData.cars.add(c);
        return c;
    }
}
