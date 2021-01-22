package com.shutl.controller;

import com.shutl.model.Quote;
import com.shutl.model.VehicleHashMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class QuoteController {

    @RequestMapping(value = "/quote", method = POST)
    public @ResponseBody Quote quote(@RequestBody Quote quote) {
        //take in markup from vehicle, calculate related price
        Double markup = VehicleHashMap.getMap().get(quote.getVehicle());
        Long price = Math.round(Math.abs((Long.valueOf(quote.getDeliveryPostcode(), 36) - Long.valueOf(quote.getPickupPostcode(), 36))/100000000) * (1 + markup));

        return new Quote(quote.getPickupPostcode(), quote.getDeliveryPostcode(),quote.getVehicle() ,price);
    }
}
