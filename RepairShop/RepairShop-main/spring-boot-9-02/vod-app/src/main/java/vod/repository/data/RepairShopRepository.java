package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vod.model.Car;
import vod.model.RepairShop;

import java.util.List;

public interface RepairShopRepository extends JpaRepository<RepairShop,Integer> {

    List<RepairShop> findAllByNameContaining(String s);

    @Query("select rs from RepairShop rs inner join rs.cars car where car=:car")
    List<RepairShop> findAllByCar(@Param("car")Car car);
}
