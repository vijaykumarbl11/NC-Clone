package com.app.neclone;

public class ServicesClass {

    String name,city,range,profession,yoe,status,image;
    int score;

    public ServicesClass() {
    }

    public ServicesClass(String name, String city, String range, String profession, String yoe, String status, String image, int score) {
        this.name = name;
        this.city = city;
        this.range = range;
        this.profession = profession;
        this.yoe = yoe;
        this.status = status;
        this.image = image;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getYoe() {
        return yoe;
    }

    public void setYoe(String yoe) {
        this.yoe = yoe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
