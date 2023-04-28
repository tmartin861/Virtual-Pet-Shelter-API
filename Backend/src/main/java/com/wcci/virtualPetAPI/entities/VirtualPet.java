package com.wcci.virtualPetAPI.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract public class VirtualPet {

    protected String petName;
    protected int happiness;
    protected int health;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private VirtualPetShelter shelter;


    public VirtualPet() {
    }

    public VirtualPet(String petName, int happiness, int health) {
        this.petName = petName;
        this.happiness = happiness;
        this.health = health;


    }


    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;

    }

    public void play() {
        happiness += 10;
        health += 10;

    }

    public void feed() {
        happiness += 10;
        health += 10;
    }

    public void tick() {
        happiness -= 5;
        health -= 5;

    }

    public void petHappiness() {
        happiness -= 5;
        health -= 5;


    }

    public void put(String petName, VirtualPet virtualPet) {
    }
}

