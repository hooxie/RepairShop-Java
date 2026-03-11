package vod;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import vod.model.RepairShop;
import vod.service.RepairShopService;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class VodComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {
    private final RepairShopService repairShopService;

    public VodComponent(RepairShopService repairShopService) {this.repairShopService = repairShopService;}
    @PostConstruct
    void init(){
        log.info("in post construct. ");}
     @Override
    public void run(String... args) throws Exception {
        log.info("program arguments: {}", Arrays.toString(args));
     }

     @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("on context refreshed");
        List<RepairShop>cinemas= repairShopService.getAllRepairShops();
        log.info("{} cinema found.", cinemas.size());
     cinemas.forEach(cinema->log.info("{}", cinema));
    }

}
