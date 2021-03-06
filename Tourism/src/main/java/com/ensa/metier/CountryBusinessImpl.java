package com.ensa.metier;

import java.util.List;

import com.ensa.dao.CountryDAO;
import com.ensa.dao.CountryDAOImpl;
import com.tourisme.entities.Country;

public class CountryBusinessImpl implements CountryBusiness {

	CountryDAO countryDAO = new CountryDAOImpl();

	@Override
	public List<Country> getAllCountries() {
		return countryDAO.getAllCountries();
	}

	@Override
	public Country saveOrUpdateCountry(Country country) {
		return countryDAO.saveOrUpdateCountry(country);
	}

	@Override
	public Country getCountryById(int id) {
		return countryDAO.getCountryById(id);
	}

	@Override
	public void deleteCountry(int id) {
		countryDAO.deleteCountry(id);
	}

}
