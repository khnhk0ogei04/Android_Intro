package com.example.viewpager.data.model;

import java.util.Objects;

public class Zodiac {
    private String name;
    private Integer drawableId;

    public Zodiac() {}
    public Zodiac(String name, Integer drawableId){
        this.name = name;
        this.drawableId = drawableId;
    }

    public String getName() {
        return name;
    }

    public Integer getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(Integer drawableId) {
        this.drawableId = drawableId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Zodiac zodiac = (Zodiac) o;
        return Objects.equals(drawableId, zodiac.drawableId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(drawableId);
    }
}
