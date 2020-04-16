package com.example.app06.model;
public class Planet{
    private String name;
    private int gravity;
    private int diameter;

    public Planet(){}

    public Planet(String name,int gravity,int diameter){
        this.name=name;
        this.gravity=gravity;
        this.diameter=diameter;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
}