package com.wsgc.shipping.rest;


import com.wsgc.shipping.model.RestrictedZipcodes;
import com.wsgc.shipping.service.ZipcodeInterval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/wsgc/shipping/")
public class ShippingZipcodes {

    @Autowired
    ZipcodeInterval zipcodeInterval;

    @PostMapping(value="/restricted/zipcodes",produces = "application/json")
    public RestrictedZipcodes addRestrictedZipcodes(@RequestBody RestrictedZipcodes request){
        zipcodeInterval.OptimizeAdd(request);
        return request;
    }
}
