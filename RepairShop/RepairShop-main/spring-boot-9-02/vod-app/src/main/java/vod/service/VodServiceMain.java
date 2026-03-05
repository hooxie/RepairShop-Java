package vod.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vod.repository.RepairShopDao;
import vod.repository.CarDao;
import vod.model.RepairShop;

import java.util.List;

public class VodServiceMain {

    public static void main(String[] args) {
        System.out.println("Let's find repair shops!");

        // przygotowanie serwisu który używa repo
        // chcemy wyswietlic listę warsztatów, repo dają dostęp do nich, ale z punktu widzenia aplikacji
        // powinnismy komunikowac sie przez serwis
        // serwis jest taka fasadą ponad repozytoriami - architektura wielowarstwowa

        // Zmieniliśmy skanowany pakiet na 'zadanie01'
        ApplicationContext context = new AnnotationConfigApplicationContext("zadanie01");

        // wyciągamy bean z kontekstu
        RepairShopService service = context.getBean(RepairShopService.class);
        RepairShopService service2 = context.getBean(RepairShopService.class);

        // service use
        // repairshopservice ma api zwraca wszystkie warsztaty
        List<RepairShop> repairShops = service.getAllRepairShops();
        System.out.println(repairShops.size() + " repair shops found:");
        repairShops.forEach(System.out::println);
    }
}
