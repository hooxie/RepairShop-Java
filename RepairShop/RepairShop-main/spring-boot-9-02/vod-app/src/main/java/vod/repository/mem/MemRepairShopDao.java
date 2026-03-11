package vod.repository.mem;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.repository.RepairShopDao;
import vod.model.RepairShop;
import vod.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Repository("RepairShopDao")
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

    @Override
    public RepairShop save(RepairShop repairShop) {
        // Szukamy najwyższego ID
        int max = SampleData.repairShops.stream()
                        .sorted((rs1,rs2)->rs2.getId()-rs1.getId())
                                .findFirst()
                                        .map(rs->rs.getId())
                                                .orElse(0);

        repairShop.setId(max+1); // Nadajemy nowe ID
        SampleData.repairShops.add(repairShop); // Zapisujemy
        return repairShop; // Zwracamy zapisany obiekt
    }
}
