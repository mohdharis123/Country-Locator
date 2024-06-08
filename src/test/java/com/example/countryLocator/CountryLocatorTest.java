package com.example.countryLocator;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CountryLocatorTest {

    private final CountryLocator countryLocator = new CountryLocator();

    @Test
    public void testGetCountryCode_US() {
        assertEquals("US", countryLocator.getCountryCode(37.7749, -122.4194)); // San Francisco
    }

    @Test
    public void testGetCountryCode_IN() {
        assertEquals("IN", countryLocator.getCountryCode(28.6139, 77.2090)); // New Delhi
    }

    @Test
    public void testGetCountryCode_Invalid() {
        assertEquals("Unknown", countryLocator.getCountryCode(0.0, 0.0)); // Middle of the ocean
    }
}

