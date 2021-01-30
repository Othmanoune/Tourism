package com.ensa.metier;

import java.util.List;

import com.tourisme.entities.Monument;

public interface MonumentBusiness {

	List<Monument> getAllMonuments();

	Monument saveOrUpdateMonument(Monument m);

	Monument getMonumentById(int id);

	void deleteMonument(int id);

}
