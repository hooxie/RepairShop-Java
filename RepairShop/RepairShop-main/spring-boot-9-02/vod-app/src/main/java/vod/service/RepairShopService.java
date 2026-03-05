package vod.service;

import vod.model.RepairShop;
import vod.model.Car;

import java.util.List;

public interface RepairShopService {
    // api zwraca nam wszystkie warsztaty
    RepairShop getRepairShopById(int id);

    List<RepairShop> getAllRepairShops();

    List<RepairShop> getRepairShopsByCar(Car c);

    List<Car> getCarsInRepairShop(RepairShop rs);
}
