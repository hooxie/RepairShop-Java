package vod.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Car;
import vod.model.Mechanic;
import vod.model.RepairShop;
import vod.repository.CarDao;

import java.util.List;

@Repository

public class JpaCarDao implements CarDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Car> findAll(){
        return entityManager
                .createQuery("select c FROM Car c")
                .getResultList();
    }
    @Override
    public Car findById(int id){
        return entityManager.find(Car.class, id);
    }
    @Override
    public List<Car> findByMechanic(Mechanic m){
        return entityManager.createQuery("select c from Car c where c.mechanic =:mechanic")
                .setParameter("mechanic",m)
                .getResultList();
    }

    @Override
    public List<Car> findByRepairShop(RepairShop rs){
        return entityManager.createQuery("select c from Car c inner join c.repairShops repairshop where repairshop =:repairshop")
                .setParameter("repairshop",rs)
                .getResultList();
    }

    @Override
    public Car add(Car c){
        entityManager.persist(c);
        return c;
    }
}
