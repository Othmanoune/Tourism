package com.ensa.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.graph.Node;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;

import com.ensa.AppConf;
import com.ensa.JenaTools;
import com.tourisme.entities.City;


public class CityDAOImpl implements CityDAO {

	
	@Override
	public List<City> getAllCities() {
		String queryS = 	
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+ "PREFIX tont: <http://localhost:8086/Spring_Etudiant/tourism.owl#> "
//				+ "SELECT ?city"
				+ "CONSTRUCT {"
				+ "		?city tont:name ?name . "
				+ "		?city tont:population ?population . "
				+ "		?city tont:security_classification ?sec . "
				+ "		?city tont:tourism_classification ?tour . "
				+ "		?city tont:ZIP_code ?zip . "
				+ "		?city tont:web_site ?site . "
				+ "}"
				+ "WHERE { "
				+ "		?counrty tont:contains ?city . "
//				+ "		?city rdf:type tont:City . "
				+ "		?city tont:name ?name . "
				+ "		?city tont:population ?population . "
				+ "		?city tont:security_classification ?sec . "
				+ "		?city tont:tourism_classification ?tour . "
				+ "		?city tont:ZIP_code ?zip . "
				+ "		?city tont:web_site ?site . "
				+ "}";
		Model model = JenaTools.executeConstructQuery(queryS);
		//System.out.println());
		//ResultSet resultSet = Tools.executeSelectQuery(queryS);
		//Model model = resultSet.getResourceModel();
		List<City> listCities = this.model2list(model);
//		for (City city : listCities) {
//			cityRepo.save(city);
//		}
		return listCities;
	}
	
	@Override
	public City saveOrUpdateCity(City city) {

		return city;
	}


	@Override
	public void deleteCity(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	private List<City> model2list(Model model) {
		StmtIterator result = model.listStatements();
		//StmtIterator result1 = resultSet.getResourceModel().listStatements();
		List<City> listCities = new ArrayList<>();
		String name = "";
		Integer population = 0;
		Integer sec = 0;
		Integer tou = 0;
		Integer zip = 0;
		String site = "";
		int count = 0;
		while (result.hasNext()) {
			Statement st = result.next();
			Node predicate = st.asTriple().getPredicate();
			//Node subject = st.asTriple().getSubject();
			Node object = st.asTriple().getObject();
			//System.out.println("---->>  " + predicate.toString() + "  " + object.toString());	
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_NAME)) 		{name=(String) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_POPULATION)) {population=(Integer) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_SECURITY_C)) {sec=(Integer) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_TOURISM_C)) 	{tou=(Integer) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_WEBSITE)) 	{site=(String) object.getLiteralValue(); count++;}
			if(predicate.toString().equals(AppConf.URI_ONTOLOGY + AppConf.PROPRETY_ZIPCODE)) 	{zip=(Integer) object.getLiteralValue(); count++;}
			if(count == 6) { 
				listCities.add(new City(name,population,sec,tou,zip,site));
				count = 0;
			}
		}
		return listCities;
	}


	@Override
	public City getCityById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
