package vod.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Car;
import vod.model.RepairShop;
import vod.repository.RepairShopDao;

import java.util.Calendar;
import java.util.List;

@Repository
@Primary
public class JpaRepairShopDao implements RepairShopDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RepairShop> findAll(){
        return entityManager
                .createQuery("select rs FROM RepairShop rs")
                .getResultList();
    }
    @Override
    public RepairShop findById(int id){
        return entityManager.find(RepairShop.class, id);
    }
    @Override
    public List<RepairShop> findByCar(Car c){
        return entityManager.createQuery("select rs from RepairShop rs inner join rs.cars car where car=:car")
                .setParameter("car",c)
                .getResultList();
    }

    @Override
    public RepairShop save(RepairShop repairShop){
        entityManager.persist(repairShop);
        return repairShop;
    }
}
