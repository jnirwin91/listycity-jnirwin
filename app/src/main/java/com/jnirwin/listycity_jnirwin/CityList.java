package com.jnirwin.listycity_jnirwin;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * Add a city to the cities list if it does not exist in the cities list already.
     * @param city
     */
    public void add(City city) {
        if(hasCity(city)) {
            throw new IllegalArgumentException("This city already exists in the list.");
        }
        cities.add(city);
    }

    /**
     * Delete a city from the cities list if it exists.
     * @param city
     */
    public void delete(City city) {
        if(!hasCity(city)) {
            throw new IllegalArgumentException("The city being deleted does not exist in the list.");
        }
        cities.remove(city);
    }

    /**
     * Check if a city is in the cities list.
     * Returns true if the city is in the list.   False otherwise.
     * @param city
     * @return boolean
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Returns the number of city objects in the cities list.
     * @return int
     */
    public int countCities() {
        return cities.size();
    }

    /**
     * Returns a sorted list of cities.
     * @return list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }
}
