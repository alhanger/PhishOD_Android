package com.phishin.entities;


import java.util.List;


/**
 * Created by robert on 5/10/14.
 */
public class Era
{
    private String name;
    private List<String> years;


    public String getName()
    {
        return name;
    }


    public void setName( String name )
    {
        this.name = name;
    }


    public List<String> getYears()
    {
        return years;
    }


    public void setYears( List<String> years )
    {
        this.years = years;
    }
}
