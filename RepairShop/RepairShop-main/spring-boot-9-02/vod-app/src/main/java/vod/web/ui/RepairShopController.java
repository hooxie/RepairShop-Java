package vod.web.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vod.model.Car;
import vod.model.RepairShop;
import vod.service.CarService;
import vod.service.RepairShopService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j

public class RepairShopController {

    private final RepairShopService repairShopService;
    private final CarService carService;

    @GetMapping("/repairshops")
    String getRepairShops(Model model, @RequestParam(value = "carId",required = false)Integer carId){
        log.info("about to display repairshops list working on cars {}",carId);
        if (carId!=null){
            Car car = carService.getCarById(carId);
            List<RepairShop> repairShops = repairShopService.getRepairShopsByCar(car);
            model.addAttribute("repairshops",repairShops);
            model.addAttribute("title","RepairShops Working on '"+ car.getBrand()+","+car.getModel()+"'");
        }
        else {
            List<RepairShop> repairShops = repairShopService.getAllRepairShops();
            model.addAttribute("repairshops",repairShops);
            model.addAttribute("title","RepairShops");
        }


        return "repairShopsView";
    }
}
