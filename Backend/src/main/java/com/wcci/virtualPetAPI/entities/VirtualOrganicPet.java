package com.wcci.virtualPetAPI.entities;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class VirtualOrganicPet extends VirtualPet implements OrganicPet {

    @ManyToOne
    public VirtualPetShelter shelter;
    protected int hunger;
    protected int thirst;

    public VirtualOrganicPet() {
        super();
    }

    public VirtualOrganicPet(String name, int happiness, int health, int hunger, int thirst, int waste)/*, int oilLevel, int maintenanceLevel)*/ {
        super(name, happiness, health);
        this.thirst = thirst;
        this.hunger = hunger;


    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public int getWasteLevel() {
        int petWaste = 20;
        return petWaste;
    }

    @Override
    public void feed() {
        super.feed();
    }


    @Override
    public void play() {
        super.play();
    }

    @Override
    public void walk() {
        happiness += 5;
        hunger -= 2;
        health += 5;
    }

    public void tick() {
        happiness -= 5;
        hunger += 2;
        health -= 5;
    }


    public int getHunger() {
        return hunger;
    }
}



