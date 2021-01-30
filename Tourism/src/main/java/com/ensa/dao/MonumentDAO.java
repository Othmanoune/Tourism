package com.ensa.dao;

import java.util.List;

import com.tourisme.entities.Monument;

public interface MonumentDAO {

	
	List<Monument> getAllMonuments();

	Monument saveOrUpdateMonument(Monument m);

	Monument getMonumentById(int id);

	void deleteMonument(int id);

}
