package vod.repository.mem;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import vod.repository.RepairShopDao;
import vod.model.RepairShop;
import vod.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Primary
public class MemRepairShopDao implements RepairShopDao {

    @Override
    public List<RepairShop> findAll() {
        return SampleData.repairShops;
    }

    @Override
    public RepairShop findById(int id) {
        return SampleData.repairShops.stream().filter(rs -> rs.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<RepairShop> findByCar(Car c) {
        return SampleData.repairShops.stream().filter(rs -> rs.getCars().contains(c)).collect(Collectors.toList());
    }
}
