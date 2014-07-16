package com.phishin.entities;


import com.phishin.PhishinClient;

import java.util.List;


/**
 * Created by Rob Munroe on 5/10/14.
 */
public class Era extends BaseModel {
    private String name;
    private List<String> years;

    public Era(PhishinClient client) {
        super(client);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getYears() {
        return years;
    }

    public void setYears(List<String> years) {
        this.years = years;
    }
}
