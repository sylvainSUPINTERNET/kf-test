package com.kf.demo.dto;

public class Profile {
    public String _id;
    public String name;
    public String age;
    public String description;
    public String proTitle;
    public String citiesInfo;
    public String liveIn;
    public String from;

    public String getId() {
        return this._id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProTitle() {
        return this.proTitle;
    }

    public void setProTitle(String proTitle) {
        this.proTitle = proTitle;
    }

    public String getCitiesInfo() {
        return this.citiesInfo;
    }

    public void setCitiesInfo(String citiesInfo) {
        this.citiesInfo = citiesInfo;
    }

    public String getLiveIn() {
        return this.liveIn;
    }

    public void setLiveIn(String liveIn) {
        this.liveIn = liveIn;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

}
