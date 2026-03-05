package vod.repository.dummy;

import org.springframework.stereotype.Component;
import vod.model.RepairShop;
import vod.model.Car;
import vod.repository.RepairShopDao;


import java.util.List;
@Component
public class DummyRepairShopDao implements RepairShopDao {
    @Override
    public List<RepairShop> findAll() {return List.of();}
    @Override
    public RepairShop findById(int id) {return null;}
    @Override
    public List<RepairShop> findByCar(Car c) {return List.of();}
}
