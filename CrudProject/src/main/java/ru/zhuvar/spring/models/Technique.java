package ru.zhuvar.spring.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Technique {
    private int id;

    @NotEmpty(message = "name can't be null")
    @Size(min = 3, max = 15, message = "length of name should be from 3 to 15 chars")
    private String name;

    @Min(value = 0, message = "number of wheels can't be less than 0")
    private int wheels;

    @Min(value = 0, message = "number of guns can't be less than 0")
    private int guns;

    public Technique() {
    }

    public Technique(int id, String name, int wheels, int guns) {
        this.id = id;
        this.name = name;
        this.wheels = wheels;
        this.guns = guns;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getGuns() {
        return guns;
    }

    public void setGuns(int guns) {
        this.guns = guns;
    }
}
