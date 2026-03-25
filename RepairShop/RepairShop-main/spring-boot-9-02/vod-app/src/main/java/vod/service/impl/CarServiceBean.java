package vod.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
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
@RequiredArgsConstructor
public class CarServiceBean implements CarService {

    private static final Logger log = Logger.getLogger(CarService.class.getName());

    private final MechanicDao mechanicDao;
    private final RepairShopDao repairShopDao;
    private final CarDao carDao;
    private final PlatformTransactionManager transactionManager;

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
        log.info("about to add car "+c);
        TransactionStatus ts =  transactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            c=carDao.add(c);
            if (c.getModel().equals("Tipo")) {
                throw new RuntimeException("not yet!");
            }
            transactionManager.commit(ts);
        } catch (RuntimeException e)
        {
            transactionManager.rollback(ts);
            throw e;
        }
        return c;

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
