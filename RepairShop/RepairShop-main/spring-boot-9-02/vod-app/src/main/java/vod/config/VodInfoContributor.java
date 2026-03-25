package vod.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import vod.service.CarService;


@Component
@RequiredArgsConstructor
public class VodInfoContributor implements InfoContributor {

    private final CarService carService;

    @Override
    public void contribute(Info.Builder builder)
    {
        builder.withDetail("cars",carService.getAllCars().size());
    }
}
