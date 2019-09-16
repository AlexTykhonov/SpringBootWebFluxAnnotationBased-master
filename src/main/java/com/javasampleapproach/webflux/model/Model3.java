package com.javasampleapproach.webflux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.ui.Model;

@Document
public class Model3 {

    @Id
    String id;
    int year;
    String make;
    String model;

    public Model3() {}
    public Model3(String id, int year, String make, String model) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
