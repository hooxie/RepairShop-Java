package vod.web.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vod.model.Car;
import vod.model.Mechanic;
import vod.model.RepairShop;
import vod.service.CarService;
import vod.service.RepairShopService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j

public class CarController {

    private final RepairShopService repairShopService;
    private final CarService carService;

    @GetMapping("/cars")
    String getCars
            (Model model,
             @RequestParam(value = "repairshopId",required = false)Integer repairshopId,
             @RequestParam(value = "mechanicId",required = false)Integer mechanicId){
        log.info("about to display cars list in repairshop {}",repairshopId);
        if (repairshopId!=null){
            RepairShop repairShop = repairShopService.getRepairShopById(repairshopId);
            List<Car> cars = repairShopService.getCarsInRepairShop(repairShop);
            model.addAttribute("cars",cars);
            model.addAttribute("title","Cars in repairshop '"+ repairShop.getName() + "'");
        }
        else if (mechanicId!=null)
        {
            Mechanic mechanic = carService.getMechanicById(mechanicId);
            List<Car> cars = carService.getCarsByMechanic(mechanic);
            model.addAttribute("cars",cars);
            model.addAttribute("title","cars being worked on by '"+mechanic.getLastName()+"'");

        }
        else{
            List<Car> cars  = carService.getAllCars();
            model.addAttribute("cars",cars);
            model.addAttribute("title","Cars");
        }
        return "carsView";
    }
}
