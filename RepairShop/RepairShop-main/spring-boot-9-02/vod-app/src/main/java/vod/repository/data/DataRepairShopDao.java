package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Car;
import vod.model.RepairShop;
import vod.repository.RepairShopDao;

import java.util.List;


@Repository
@Primary
@RequiredArgsConstructor
public class DataRepairShopDao implements RepairShopDao {
    private final RepairShopRepository repository;

    @Override
    public List<RepairShop> findAll()
    {return repository.findAll();}

    @Override
    public RepairShop findById(int id){return repository.findById(id).orElse(null);}

    @Override
    public List<RepairShop> findByCar(Car c){return repository.findAllByCar(c);}

    @Override
    public RepairShop save(RepairShop repairShop){return repository.save(repairShop);}
}
