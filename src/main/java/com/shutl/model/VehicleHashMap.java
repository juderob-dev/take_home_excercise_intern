package com.shutl.model;

import java.util.HashMap;

public class VehicleHashMap {
//create lookup table for markup related to a vehicle
    public static HashMap<String, Double> getMap() {

        HashMap<String, Double> vehicleMap = new HashMap<String, Double>();

        // Add keys and values (vehicle, markup percent)
        vehicleMap.put("Bicycle", 0.1);
        vehicleMap.put("Motorbike",0.15);
        vehicleMap.put("Parcel Car", 0.2);
        vehicleMap.put("Small Van", 0.3);
        vehicleMap.put("Large Van", 0.4);

        return vehicleMap;

    }

}
