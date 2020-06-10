package demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.bean.Country;
import demo.bean.CountryList;

@RestController
public class CountryController {
	
	@RequestMapping(value = "/countries", method = RequestMethod.GET, produces = { "application/json", "application/xml" }, consumes = { "application/json", "application/xml" })
	public CountryList getCountries()
	{
		CountryList countryList=createCountryList();
		return countryList;
	}

	@RequestMapping(value = "/country/{id}", method = RequestMethod.GET)
	public Country getCountryById(@PathVariable int id)
	{
		List<Country> listOfCountries = new ArrayList<Country>();
		CountryList countryList=createCountryList();
		listOfCountries=countryList.getListOfCountries();
		for (Country country: listOfCountries) {
			if(country.getId()==id)
				return country;
		}
		
		return null;
	}

/// Utiliy method to create country list.
	public CountryList createCountryList()
	{
		Country indiaCountry=new Country(1, "India");
		Country chinaCountry=new Country(4, "China");
		Country nepalCountry=new Country(3, "Nepal");
		Country bhutanCountry=new Country(2, "Bhutan");

		List<Country> listOfCountries = new ArrayList<Country>();
		listOfCountries.add(indiaCountry);
		listOfCountries.add(chinaCountry);
		listOfCountries.add(nepalCountry);
		listOfCountries.add(bhutanCountry);
		return new CountryList(listOfCountries);
	}
}
