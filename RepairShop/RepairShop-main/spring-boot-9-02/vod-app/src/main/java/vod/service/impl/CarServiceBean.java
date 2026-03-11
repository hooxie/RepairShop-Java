package vod.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vod.repository.RepairShopDao;
import vod.repository.CarDao;
import vod.repository.MechanicDao;
import vod.model.RepairShop;
import vod.model.Mechanic;
import vod.model.Car;
import vod.service.CarService;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CarServiceBean implements CarService {

    private static final Logger log = Logger.getLogger(CarService.class.getName());

    private MechanicDao mechanicDao;
    private RepairShopDao repairShopDao;
    private CarDao carDao;

    public CarServiceBean(MechanicDao mechanicDao, RepairShopDao repairShopDao, CarDao carDao) {
        this.mechanicDao = mechanicDao;
        this.repairShopDao = repairShopDao;
        this.carDao = carDao;
    }

    @Autowired
    public void setMechanicDao(MechanicDao mechanicDao) {
        this.mechanicDao = mechanicDao;
    }

    @Override
    public List<Car> getAllCars() {
        log.info("searching all cars...");
        return carDao.findAll();
    }

    @Override
    public List<Car> getCarsByMechanic(Mechanic m) {
        log.info("searching cars by mechanic " + m.getId());
        return carDao.findByMechanic(m);
    }

    @Override
    public Car getCarById(int id) {
        log.info("searching car by id " + id);
        return carDao.findById(id);
    }

    @Override
    public Car addCar(Car c) {
        return carDao.add(c);
    }

    @Override
    public List<Mechanic> getAllMechanics() {
        log.info("searching all mechanics");
        return mechanicDao.findAll();
    }

    @Override
    public Mechanic getMechanicById(int id) {
        log.info("searching mechanic by id " + id);
        return mechanicDao.findById(id);
    }

    @Override
    public Mechanic addMechanic(Mechanic m) {
        return mechanicDao.add(m);
    }
}
