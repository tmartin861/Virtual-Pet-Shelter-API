package com.wcci.virtualPetAPI.entities;

import javax.persistence.*;

@Entity
public class RoboticCat extends VirtualRoboticPet implements RoboticPet{

    protected int batteryLife;
    protected int oil;

    public RoboticCat() {
        super();
    }

    public RoboticCat(String name, int happiness, int health, int oil, int batteryLife) {
        super(name, happiness, health, oil, batteryLife);
        this.batteryLife = batteryLife;
        this.oil = oil;

    }

    @Override
    public int batteryLife() {

        return batteryLife;
    }

    @Override
    public int oil() {
        return oil;
    }

    @Override
    public void tick() {
        batteryLife -= 5;
        oil -= 5;

    }
}



