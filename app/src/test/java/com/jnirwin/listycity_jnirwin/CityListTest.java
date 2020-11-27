package com.jnirwin.listycity_jnirwin;

import android.util.Log;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Grande Prairie", "Alberta");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("London", "Ontario");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Guelph", "Ontario");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Airdrie", "Alberta");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        CityList cityList = mockCityList();
        City city = new City("Airdrie", "Alberta");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));

        City city2 = new City("Edmonton", "Alberta");
        assertFalse(cityList.hasCity(city2));
        cityList.add(city2);
        assertTrue(cityList.hasCity(city2));
    }

    @Test
    public void testDeleteCity() {
        CityList cityList = mockCityList();
        City city = new City("Airdrie", "Alberta");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    public void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        City city = new City("Airdrie", "Alberta");
        cityList.add(city);
        assertEquals(2, cityList.countCities());
    }
}
