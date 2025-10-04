package com.example.gridview.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {
    @JsonProperty("name")
    private String nation;

    @JsonProperty("capital")
    private String capital;

    @JsonProperty("flag")
    private String flag;

    @JsonProperty("area")
    private int area;

    @JsonProperty("density")
    private int density;

    @JsonProperty("population")
    private float population;

    @JsonProperty("world_share")
    private String worldShare;

    public Country() {}

    public String getNation() {
        return nation;
    }

    public String getCapital() {
        return capital;
    }

    public String getFlag() {
        return flag;
    }

    public int getArea() {
        return area;
    }

    public float getPopulation() {
        return population;
    }

    public int getDensity() {
        return density;
    }

    public String getWorldShare() {
        return worldShare;
    }
}
