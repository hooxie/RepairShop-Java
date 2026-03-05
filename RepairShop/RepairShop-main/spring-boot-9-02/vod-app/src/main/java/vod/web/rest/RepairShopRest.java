package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vod.model.RepairShop;
import vod.service.RepairShopService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RepairShopRest {

    // Dzięki adnotacji @RequiredArgsConstructor Lombok sam wygeneruje konstruktor dla tego pola
    private final RepairShopService repairShopService;

    @GetMapping("/repairshops")
    public List<RepairShop> getRepairShops() {
        log.info("about to retrieve repair shops list");
        List<RepairShop> repairShops = repairShopService.getAllRepairShops();
        log.info("{} repair shops found.", repairShops.size());
        return repairShops;
    }
}
