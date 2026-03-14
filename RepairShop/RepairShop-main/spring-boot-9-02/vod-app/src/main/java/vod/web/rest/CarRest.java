package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vod.model.Car;
import vod.model.RepairShop;
import vod.service.CarService;
import vod.service.RepairShopService;
import vod.web.rest.dto.CarDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class CarRest {
    private final RepairShopService repairShopService;
    private final CarService carService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
//    private final RepairShopValidator repairShopValidator;
//
//    @InitBinder
//    void initBinder(WebDataBinder binder){
//        binder.addValidators(repairShopValidator);
//    }

    @GetMapping("/cars")
    List<Car> getCars(){
        log.info("about to retrive cars list");
        List<Car> cars = carService.getAllCars();
        log.info("{} cars found",cars.size());
        return cars;
    }

    @GetMapping("/cars/{id}")
    ResponseEntity<Car> getCar(@PathVariable("id") int id){
        log.info("about to retrive cars list",id);
        Car car = carService.getCarById(id);
        log.info("car found: {}",car);
        if (car!=null){
            return ResponseEntity.ok(car);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/repairshops/{repairshopId}/cars")
    ResponseEntity<List<Car>> getCarsWorkedOnAtRepairShop(@PathVariable("repairshopId") int repairshopId) {
        log.info("about to retrive cars working on at repairshop",repairshopId);
        RepairShop repairShop = repairShopService.getRepairShopById(repairshopId);
        if (repairShop==null){
            return ResponseEntity.notFound().build();
        }else{
            List<Car> cars=repairShopService.getCarsInRepairShop(repairShop);
            log.info("there's {} cars being worked on at repairshop {}",cars.size(),repairShop.getName());
            return ResponseEntity.ok(cars);
        }
    }

    @PostMapping("/car")
    ResponseEntity<?> addCar(@RequestBody CarDTO carDTO)
    {
        log.info("about to add new car {}",carDTO);
        Car car = new Car();
        car.setBrand(carDTO.getBrand());
        car.setModel(carDTO.getModel());
        car.setMechanic(carService.getMechanicById(carDTO.getMechanicId()));

        car = carService.addCar(car);
        log.info("new car added: {}",car);
        return ResponseEntity
                //.status(HttpStatus.CREATED)
                .created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequestUri()
                                .path("/"+car.getId())
                                .build()
                                .toUri())
                .body(car);
    }



}
