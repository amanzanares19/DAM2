package com.example.anime;

import java.io.Serializable;

public class Animal implements Serializable {

    private String urlImage;
    private String name;
    private String type;
    private int age;

    private int birthdateYear;
    private String[] meals;
    private String description;


    public Animal() {

    }

    public Animal(String urlImage, String name, String type, int age, int birthdateYear, String[] meals, String description) {
        this.urlImage = urlImage;
        this.name = name;
        this.type = type;
        this.age = age;
        this.birthdateYear = birthdateYear;
        this.meals = meals;
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBirthdateYear() {
        return birthdateYear;
    }

    public void setBirthdateYear(int birthdateYear) {
        this.birthdateYear = birthdateYear;
    }

    public String getMeals() {

        String text = null;
        for (String meal : meals) {
            if (text == null) {
                text = meal;
            } else {
                text = text + ", " + meal;
            }
        }

        return text;
    }

    public void setMeals(String[] meals) {
        this.meals = meals;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
