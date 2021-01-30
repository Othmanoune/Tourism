package com.ensa.metier;

import java.util.List;

import com.tourisme.entities.City;

public interface CityBusiness {

	public List<City> getAllCities();
	public City saveOrUpdateCity(City city);
	public City getCityById(int id);
	public void deleteCity(int id);
	
	
}
