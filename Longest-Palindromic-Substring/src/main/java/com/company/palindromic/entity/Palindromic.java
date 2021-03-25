package com.company.palindromic.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "palindromic")
public class Palindromic {
    @Id
    private String origin;
    private String longest_palindromic;

    public Palindromic() {}

    public Palindromic(String origin, String longest_palindromic) {
        this.origin = origin;
        this.longest_palindromic = longest_palindromic;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getLongest_palindromic() {
        return longest_palindromic;
    }

    public void setLongest_palindromic(String longest_palindromic) {
        this.longest_palindromic = longest_palindromic;
    }

    @Override
    public String toString() {
        return "Palindromic{" +
                "origin='" + origin + '\'' +
                ", longest_palindromic='" + longest_palindromic + '\'' +
                '}';
    }
}
