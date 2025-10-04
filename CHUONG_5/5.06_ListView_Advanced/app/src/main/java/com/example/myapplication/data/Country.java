package com.example.myapplication.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Country {
    @JsonProperty("name")
    public String mName;

    @JsonProperty("flag")
    public String mFlag;

    @JsonProperty("capital")
    public String mCapital;

    @JsonProperty("population")
    public float mPopulation;

    @JsonProperty("density")
    public int mDensity;

    @JsonProperty("area")
    public int mArea;

    @JsonProperty("world_share")
    public String mWorldShare;
    public Country(){

    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getFlag() {
        return mFlag;
    }

    public void setFlag(String mFlag) {
        this.mFlag = mFlag;
    }

    public String getCapital() {
        return mCapital;
    }

    public void setCapital(String mCapital) {
        this.mCapital = mCapital;
    }

    public float getPopulation() {
        return mPopulation;
    }

    public void setPopulation(float mPopulation) {
        this.mPopulation = mPopulation;
    }

    public int getDensity() {
        return mDensity;
    }

    public void setDensity(int mDensity) {
        this.mDensity = mDensity;
    }

    public int getArea() {
        return mArea;
    }

    public void setArea(int mArea) {
        this.mArea = mArea;
    }

    public String getWorldShare() {
        return mWorldShare;
    }

    public void setWorldShare(String mWorldShare) {
        this.mWorldShare = mWorldShare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(mName, country.mName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mName);
    }
}
