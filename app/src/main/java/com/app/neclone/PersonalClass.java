package com.app.neclone;

public class PersonalClass {

    String name,city,profession,status,image,range;
    int score;

    public PersonalClass() {
    }

    public PersonalClass(String name, String city, String profession, String status, String image, String range, int score) {
        this.name = name;
        this.city = city;
        this.profession = profession;
        this.status = status;
        this.image = image;
        this.range = range;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
