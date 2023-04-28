package com.wcci.virtualPetAPI.entities;

import javax.persistence.*;

@Entity
public class OrganicCat extends VirtualOrganicPet implements OrganicPet {

    protected int hunger;
    protected int waste;


    public OrganicCat() {
    }

    public OrganicCat(String name, int happiness, int hunger, int health, int thirst, int waste) {
        super(name, happiness, health, hunger, thirst, waste);
        this.hunger = hunger;
        this.waste = waste;
        this.thirst = thirst;

    }

    @Override
    public void walk() {
        happiness += 5;
        health += 5;
        thirst += 5;
        hunger -= 5;

    }

    @Override
    public void tick() {
        happiness -= 5;
        health -= 5;
        thirst += 5;
        hunger += 5;

    }

    public void feed() {
        setHunger(getHunger() + 5);
    }

    @Override
    public void thirst() {
        happiness += 5;
        health += 5;
        hunger -= 5;
        thirst -= 5;
    }


    public void emptyLitterBox() {
        happiness += 5;
        health += 5;
        thirst += 5;
        hunger -= 5;
    }


    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
}
