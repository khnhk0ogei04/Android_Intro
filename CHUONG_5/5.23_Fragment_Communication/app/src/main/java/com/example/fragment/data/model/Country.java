package com.example.fragment.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Country implements Serializable {
    @JsonProperty("name")
    private String name;

    @JsonProperty("flag")
    private String flag;

    @JsonProperty("capital")
    private String capital;

    @JsonProperty("population")
    private float population;

    @JsonProperty("density")
    private int density;

    @JsonProperty("area")
    private int area;

    @JsonProperty("world_share")
    private String worldShare;

    @SuppressWarnings("unused")
    public Country() {}

    @SuppressWarnings("unused")
    public Country(String name, String flag, String capital,
                   float population, int density, int area, String worldShare) {
        this.name = name;
        this.flag = flag;
        this.capital = capital;
        this.population = population;
        this.density = density;
        this.area = area;
        this.worldShare = worldShare;
    }

    public String getName() {
        return name;
    }

    public String getFlag() {
        return flag;
    }

    public String getCapital() {
        return capital;
    }

    public float getPopulation() {
        return population;
    }

    public int getDensity() {
        return density;
    }

    public int getArea() {
        return area;
    }

    public String getWorldShare() {
        return worldShare;
    }
}
