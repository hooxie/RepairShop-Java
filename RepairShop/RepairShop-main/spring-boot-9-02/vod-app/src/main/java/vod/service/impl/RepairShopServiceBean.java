package vod.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import vod.model.RepairShop;
import vod.model.Car;
import vod.repository.RepairShopDao;
import vod.repository.CarDao;
import vod.service.RepairShopService;

import java.util.List;
import java.util.logging.Logger;

@Service
@Scope("prototype")
public class RepairShopServiceBean implements RepairShopService {

    private static final Logger log = Logger.getLogger(RepairShopService.class.getName());

    private RepairShopDao repairShopDao;
    private CarDao carDao;

    public RepairShopServiceBean(RepairShopDao repairShopDao, CarDao carDao) {
        log.info("creating repair shop service bean");
        this.repairShopDao = repairShopDao;
        this.carDao = carDao;
    }

    @Override
    public RepairShop getRepairShopById(int id) {
        log.info("searching repair shop by id " + id);
        return repairShopDao.findById(id);
    }

    @Override
    public List<Car> getCarsInRepairShop(RepairShop rs) {
        log.info("searching cars serviced in repair shop " + rs.getId());
        return carDao.findByRepairShop(rs);
    }

    @Override
    public List<RepairShop> getAllRepairShops() {
        log.info("searching all repair shops");
        return repairShopDao.findAll();
    }

    @Override
    public List<RepairShop> getRepairShopsByCar(Car c) {
        log.info("searching repair shops by car " + c.getId());
        return repairShopDao.findByCar(c);
    }

    @Override
    public RepairShop addRepairShop(RepairShop repairShop) {
        log.info("adding new repair shop: " + repairShop);
        return repairShopDao.save(repairShop);
    }
}
