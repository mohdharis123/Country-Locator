package com.example.countryLocator;

import java.util.HashMap;
import java.util.Map;

public class CountryLocator {

    private static final Map<String, double[][]> COUNTRY_BOUNDARIES = new HashMap<>();

    static {
        COUNTRY_BOUNDARIES.put("US", new double[][]{{24.396308, 49.384358}, {-125.0, -66.93457}});
        COUNTRY_BOUNDARIES.put("IN", new double[][]{{8.4, 37.6}, {68.7, 97.25}});
    }

    public String getCountryCode(double latitude, double longitude) {
        for (Map.Entry<String, double[][]> entry : COUNTRY_BOUNDARIES.entrySet()) {
            double[][] bounds = entry.getValue();
            if (latitude >= bounds[0][0] && latitude <= bounds[0][1]
                    && longitude >= bounds[1][0] && longitude <= bounds[1][1]) {
                return entry.getKey();
            }
        }
        return "Unknown";
    }
}
