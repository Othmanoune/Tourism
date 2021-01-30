package com.ensa.metier;

import java.util.List;

import com.ensa.dao.CityDAO;
import com.ensa.dao.CityDAOImpl;
import com.tourisme.entities.City;

public class CityBusinessImpl implements CityBusiness {

	CityDAO cityDAO = new CityDAOImpl();

	@Override
	public List<City> getAllCities() {
		return cityDAO.getAllCities();
	}

	@Override
	public City saveOrUpdateCity(City city) {
		//cityRepository.save(city);
		return cityDAO.saveOrUpdateCity(city);
	}

	@Override
	public City getCityById(int id) {
		return cityDAO.getCityById(id);
	}

	@Override
	public void deleteCity(int id) {
		cityDAO.deleteCity(id);
	}

}
