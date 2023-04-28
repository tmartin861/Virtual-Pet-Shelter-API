package com.wcci.virtualPetAPI.entities;

import javax.persistence.*;

@Entity
public class OrganicDog extends VirtualOrganicPet implements OrganicPet {

    protected int hunger;
    protected int thirst;
    protected int waste;

    public OrganicDog() {
    }

    public OrganicDog(String name, int happiness, int health, int hunger, int thirst, int waste) {
        super(name, happiness, health, hunger, thirst, waste);

        this.hunger = hunger;
        this.thirst = thirst;
        this.waste = waste;
    }

    @Override
    public void tick() {
        happiness -= 5;
        health -= 5;
        thirst += 5;
        hunger += 5;
    }

    public void feed() {
        setHunger(getHunger() - 5);
    }

    @Override
    public void thirst() {
        happiness += 5;
        health += 5;
        hunger -= 5;
        thirst -= 5;
    }

    @Override
    public void walk() {
        super.walk();
        setWaste(getWaste() - 5);
    }

    public void cleanCages() {
        setWaste(getWaste() - 5);
    }

    public int getWaste() {
        return waste;
    }

    public void setWaste(int waste) {
        this.waste = waste;
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }


}

