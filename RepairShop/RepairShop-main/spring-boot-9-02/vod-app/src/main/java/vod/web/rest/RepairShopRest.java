package vod.web.rest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.LocaleResolver;
import vod.model.Car;
import vod.model.RepairShop;
import vod.service.CarService;
import vod.service.RepairShopService;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class RepairShopRest {
    private final RepairShopService repairShopService;
    private final CarService carService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    private final RepairShopValidator validator;

    @InitBinder
    void initBinder(WebDataBinder binder) {binder.addValidators(validator);}

    @GetMapping("/repairshops")
    public List<RepairShop> getRepairShops(
            @RequestParam(value = "phrase", required = false) String phrase,
            @RequestHeader(value = "custom-header", required = false) String customHeader,
            @CookieValue(value = "some-cookie", required = false) String someCookie
    ) {
        log.info("about to retrieve repair shops list");

        // Logowanie przekazanych parametrów (tak jak w instrukcji)
        log.info("phrase param: " + phrase);
        log.info("custom header param: " + customHeader);
        log.info("some cookie value: " + someCookie);

        List<RepairShop> repairShops = repairShopService.getAllRepairShops();
        log.info("repair shops found: " + repairShops.size());

        return repairShops;
    }

    @GetMapping("/repairshops/{id}")
    ResponseEntity<RepairShop> getRepairShop(@PathVariable("id") int id) {
        log.info("about to retrieve repair shops {}",id);
        RepairShop repairShop = repairShopService.getRepairShopById(id);
        log.info("repair shops found: {}", repairShop);
        if(repairShop!=null)
        {
            return  ResponseEntity.status(200).body(repairShop);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cars/{carId}/repairshops")
    ResponseEntity<List<RepairShop>> getRepairShopsWorkingOnCar(@PathVariable("carId") int carId) {
        log.info("about to retrieve repair shops working on car {}",carId);
        Car car = carService.getCarById(carId);
        if(car==null)
        {
            return  ResponseEntity.notFound().build();
        } else {
            List<RepairShop> repairShops = repairShopService.getRepairShopsByCar(car);
            log.info("there is"+repairShops.size() +  " repair shops working on car"+car.getBrand()+" "+car.getModel());
            return ResponseEntity.ok(repairShops);
        }
    }

    @PostMapping("/repairshop")
    ResponseEntity<?> addRepairShop(@Validated @RequestBody RepairShop repairShop, Errors errors, HttpServletRequest request) {
        log.info("about to add new repair shop: {}", repairShop);

        if(errors.hasErrors()) {
            Locale locale = localeResolver.resolveLocale(request);
            String errorMessage = errors.getAllErrors().stream()
                    .map(oe->messageSource.getMessage(oe.getCode(),new Object[0],locale))
                    .reduce("errors:\n",(accu,oe)->accu+oe+"\n");
            return ResponseEntity.badRequest().body(errorMessage);
        }

        repairShop = repairShopService.addRepairShop(repairShop);
        log.info("new repair shop added: {}", repairShop);

        return ResponseEntity.status(HttpStatus.CREATED).body(repairShop);
    }
}
