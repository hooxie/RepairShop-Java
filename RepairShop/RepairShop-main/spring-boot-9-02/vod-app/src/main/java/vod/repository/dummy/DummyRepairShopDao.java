//package vod.repository.dummy;
//
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//import vod.model.RepairShop;
//import vod.model.Car;
//import vod.repository.RepairShopDao;
//
//
//import java.util.List;
//@Repository("dummyRepairShopDao") // Zmiana z @Component na @Repository z nazwą
//public class DummyRepairShopDao implements RepairShopDao {
//
//    @Override
//    public List<RepairShop> findAll() {
//        return List.of();
//    }
//
//    @Override
//    public RepairShop findById(int id) {
//        return null;
//    }
//
//    @Override
//    public List<RepairShop> findByCar(Car c) {
//        return List.of();
//    }
//
//    // NOWA METODA: Wymagana po aktualizacji interfejsu RepairShopDao
//    @Override
//    public RepairShop add(RepairShop rs) {
//        return null; // To jest "dummy", więc może po prostu zwracać null
//    }
//}
