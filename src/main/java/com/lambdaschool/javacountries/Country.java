package com.lambdaschool.javacountries;

import java.util.concurrent.atomic.AtomicLong;

public class Country
{

    //Static field
    private static final AtomicLong counter = new AtomicLong();

    //Fields for object
    private String name;
    private int population;
    private int landMass;
    private int medianAge;

    //Constructor
    public Country(String name, int population, int landMass, int medianAge)
    {
        this.name = name;
        this.population = population;
        this.landMass = landMass;
        this.medianAge = medianAge;
    }

    //Getter and Setter

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPopulation()
    {
        return population;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }

    public int getLandMass()
    {
        return landMass;
    }

    public void setLandMass(int landMass)
    {
        this.landMass = landMass;
    }

    public int getMedianAge()
    {
        return medianAge;
    }

    public void setMedianAge(int medianAge)
    {
        this.medianAge = medianAge;
    }

    //toString()

    @Override
    public String toString()
    {
        return "Country{" + "name='" + name + '\'' + ", population=" + population + ", landMass=" + landMass + ", medianAge=" + medianAge + '}';
    }
}
