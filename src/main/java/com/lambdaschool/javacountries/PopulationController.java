package com.lambdaschool.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController
{
    //localhost:2019/population/size/{num}
    //return the countries alphabetically that have a name equal to or longer than the given length

    @GetMapping(value = "/size/{num}",
                produces = {"application/json"})
    public ResponseEntity<?> getSizeOfCountryName(@PathVariable long num)
    {
        ArrayList<Country> rtnPopulation = JavaCountriesApplication.myCountryList
                .findCountries(c -> c.getPopulation() >= num);
        rtnPopulation.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(rtnPopulation, HttpStatus.OK);

    }

    //localhost:2019/population/people
    //return the countries that have a population equal to or greater than the given population

    //localhost:2019/population/min
    //return the country with the smallest population

    @GetMapping(value = "/min",
                produces = {"application/json"})
    public Country getSmallestPopulation()
    {
        long min = 1000000000;
        Country country = null;
        for (Country c: JavaCountriesApplication.myCountryList.countryList)
        {
            if(c.getPopulation() <= min)
            {
                min = c.getPopulation();
                country = c;
            }
        }
        return country;
    }


    //localhost:2019/population/max
    //return the country with the largest population

}
