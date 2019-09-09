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

    //localhost:2019/data/size/25
        //return the countries alphabetically that have a name equal to or longer than the given length

//    @GetMapping(value = "/size/{num}",
//                produces = {"application/json"})
//    public ResponseEntity<?> getCountryBySize()
//    {
//        ArrayList<Country> rtnCountry = JavaCountriesApplication.myCountryList.countryList;
//        rtnCountry.sort((c1,c2) -> c1.getName() - c2.getName());
//
//    }

    //localhost:2019/data/people
        //return the countries that have a population equal to or greater than the given population

    //localhost:2019/data/min
        //return the country with the smallest population

//    @GetMapping(value = "/size/{num}", produces = {"application/json"})
//        public ResponseEntity<?> getCountryByMinPopulationSize(@PathVariable char num)
//        {
//            ArrayList<Country> rtnCount1 = JavaCountriesApplication.myCountryList
//                    .findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
//
//            rtnCount1.sort((c1,c2) -> ((int)c1.getPopulation() - c2.getPopulation()));
//
//            return new ResponseEntity<>(rtnCount1, HttpStatus.OK);
//
//        }

    //localhost:2019/data/max
        //return the country with the largest population
}
