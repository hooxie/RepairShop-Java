package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.Mechanic;
import vod.model.RepairShop;
import vod.service.CarService;
import vod.service.RepairShopService;
import vod.web.rest.dto.CarDTO;

@Component
@RequiredArgsConstructor
public class CarValidator implements Validator {

    private final CarService carService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(CarDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        CarDTO car = (CarDTO) target;

        Mechanic mechanic = carService.getMechanicById(car.getMechanicId());
        if (mechanic==null)
        {
            errors.rejectValue("mechanicId","car.mechanic.missing");
        }
    }
}
