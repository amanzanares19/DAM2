package com.example.anime;

import java.io.Serializable;

public class Animal implements Serializable {

    private String urlImage;
    private String name;
    private String type;
    private int age;


    public Animal() {

    }

    public Animal(String urlImage, String name, String type, int age) {
        this.urlImage = urlImage;
        this.name = name;
        this.type = type;
        this.age = age;
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
}
