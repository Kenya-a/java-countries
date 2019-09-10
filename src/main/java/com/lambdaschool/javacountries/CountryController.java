package com.lambdaschool.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/data")
public class CountryController
{
    //localhost:2019/data/allcountries
      //return the names of all the countries alphabetically
    @GetMapping(value = "/allcountries",
                produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        ArrayList<Country> rtnCountry = JavaCountriesApplication.myCountryList.countryList;
        rtnCountry.sort((c1,c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    //localhost:2019/data/start/k
        //return the countries alphabetically that begin with the given letter
    @GetMapping(value = "/start/{letter}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByFirstLetter(@PathVariable char letter)
    {
        ArrayList<Country> rtnCountries = JavaCountriesApplication.myCountryList
                .findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

}
