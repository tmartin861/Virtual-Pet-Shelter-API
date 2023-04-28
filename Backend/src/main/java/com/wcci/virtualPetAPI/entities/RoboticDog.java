package com.wcci.virtualPetAPI.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class RoboticDog extends VirtualRoboticPet implements RoboticPet {

    @OneToMany(mappedBy = "pets")
    public VirtualPetShelter shelter;
    protected int batteryLife;
    protected int oil;

    public RoboticDog() {
        super();
    }

    public RoboticDog(String name, int happiness, int health, int oil, int batteryLife) {
        super(name, happiness, health, oil, batteryLife);
        this.batteryLife = batteryLife;
        this.oil = oil;

    }

    @Override
    public void tick() {
        batteryLife -= 5;
        oil -= 5;

    }

    @Override
    public int oil() {
        return oil;
    }

    public int setOil(int oil) {
        this.oil = oil;
        return oil;
    }

    @Override
    public int getOil() {
        return oil;
    }

}
