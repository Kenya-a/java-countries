package com.lambdaschool.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    //localhost:2019/data/size/25
        //return the countries alphabetically that have a name equal to or longer than the given length

    //localhost:2019/data/people
        //return the countries that have a population equal to or greater than the given population

    //localhost:2019/data/min
        //return the country with the smallest population

    //localhost:2019/data/max
        //return the country with the largest population
}
