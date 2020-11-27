package com.jnirwin.listycity_jnirwin;

public class City implements Comparable<City> {
    private String city;
    private String province;

    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    /**
     * Overridden method to comare two cities by their name.
     * @param city Takes a city object.
     * @return boolean
     */
    @Override
    public int compareTo(City city) {
        return this.city.compareTo(city.getCityName());
    }
}
