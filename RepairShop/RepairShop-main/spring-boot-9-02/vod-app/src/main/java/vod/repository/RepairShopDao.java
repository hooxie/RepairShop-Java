package vod.repository;

import vod.model.Car;
import vod.model.RepairShop;

import java.util.List;

public interface RepairShopDao {
    List<RepairShop> findAll();
    RepairShop findById(int id);
    List<RepairShop> findByCar(Car c);
    RepairShop save(RepairShop repairShop);
}
