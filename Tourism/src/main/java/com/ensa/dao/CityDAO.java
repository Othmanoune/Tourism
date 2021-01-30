package com.ensa.dao;

import java.util.List;

import com.tourisme.entities.City;


public interface CityDAO {

	public List<City> getAllCities();
	public City saveOrUpdateCity(City city);
	public City getCityById(int id);
	public void deleteCity(int id);
	
}
