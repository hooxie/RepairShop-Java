package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Car;
import vod.model.Mechanic;
import vod.model.RepairShop;
import vod.repository.CarDao;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class DataCarDao implements CarDao {

    private final CarRepository repository;

    @Override
    public List<Car> findAll() {
        return repository.findAll();
    }

    @Override
    public Car findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Car> findByMechanic(Mechanic m) {
        return repository.findAllByMechanic(m);
    }

    @Override
    public List<Car> findByRepairShop(RepairShop rs) {
        return repository.findAllByRepairShopsContaining(rs);
    }

    @Override
    public Car add(Car c) {
        return repository.save(c);
    }
}