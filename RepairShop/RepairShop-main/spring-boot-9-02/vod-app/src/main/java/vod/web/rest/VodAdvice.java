package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class VodAdvice {

    private final RepairShopValidator repairShopValidator;
    private final CarValidator carValidator;

    @InitBinder("repairShop")
    void initBinderForRepairShop(WebDataBinder binder) {
        binder.addValidators(repairShopValidator);
    }

    @InitBinder("carDTO")
    void initBinderForCar(WebDataBinder binder) {
        binder.addValidators(carValidator);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e)
    {
        log.error("illegal argument provided",e);
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<String> handleException(Exception e)
    {
        log.error("generic exception",e);
        return ResponseEntity.status(HttpStatus.LOOP_DETECTED).body(e.getMessage());
    }
}
