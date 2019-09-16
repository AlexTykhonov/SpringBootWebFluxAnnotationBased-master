package com.javasampleapproach.webflux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Supplier {

    @Id
    String id;
String company;
Integer taxcode;

 public Supplier () {};


 public Supplier (String id, String company, Integer taxcode) {
this.id = id;
this.company = company;
this.taxcode = taxcode;
 }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getTaxcode() {
        return taxcode;
    }

    public void setTaxcode(Integer taxcode) {
        this.taxcode = taxcode;
    }

    @Override
    public String toString() {
        String info = String.format("id = %s, company = %s, taxcode = %i", id, company, taxcode);
        return info;
    }
}
