package org.example;

public class Geoloc {
    private Geoloc parent;
    private Geotype geoType;
    private String name;


    public void setName(String name) {
        this.name = name;
    }

    public void setGeoType(Geotype geoType) {
        this.geoType = geoType;
    }

    public void setParent(Geoloc parent) {
        this.parent = parent;
    }

    public Geoloc getParent() {
        return this.parent;
    }

    public Geotype getGeoType() {
        return this.geoType;
    }

    public String getName() {
        return this.name;
    }

}
