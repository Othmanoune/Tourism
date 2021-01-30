package com.ensa.metier;

import java.util.List;

import com.tourisme.entities.Country;

public interface CountryBusiness {

	public List<Country> getAllCountries();
	public Country saveOrUpdateCountry(Country country);
	public Country getCountryById(int id);
	public void deleteCountry(int id);
	
	
}
