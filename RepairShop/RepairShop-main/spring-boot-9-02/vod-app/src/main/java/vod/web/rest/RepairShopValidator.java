package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.RepairShop;
import vod.service.RepairShopService;

@Component
@RequiredArgsConstructor
public class RepairShopValidator implements Validator {

    private final RepairShopService repairShopService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RepairShop.class);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        RepairShop validatedRepairShop = (RepairShop) target;

        boolean duplicated = repairShopService.getAllRepairShops().stream()
                .anyMatch(repairShop -> repairShop.getName().equalsIgnoreCase(validatedRepairShop.getName()));
        if (duplicated){
            errors.rejectValue("name","repairShop.name.duplicated");
        }
    }
}
