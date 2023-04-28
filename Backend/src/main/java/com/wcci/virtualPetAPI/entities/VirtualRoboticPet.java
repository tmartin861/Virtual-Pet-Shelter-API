package com.wcci.virtualPetAPI.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class VirtualRoboticPet extends VirtualPet {


    @ManyToOne
    public VirtualPetShelter shelter;
    protected String name;
    protected int happiness;
    protected int health;
    @Id
    @GeneratedValue
    private Long id;
    private int oil;
    private int batteryLife;


    protected VirtualRoboticPet() {
        super();
    }

    public VirtualRoboticPet(String name, int happiness, int health, int oilLevel, int batteryLife) {
        super(name, happiness, health);
        this.name = name;
        this.happiness = happiness;
        this.health = health;
        this.oil = oil;
        this.batteryLife = batteryLife;
    }

    public String name() {
        return name;
    }

    public String getRoboticPetName() {
        return name;
    }

    public int happiness() {
        return happiness;
    }

    public int getOil() {
        return oil;
    }

    public int setOil(int oil) {
        this.oil = oil;
        return oil;
    }

    public int getRoboticPetHealth() {
        return health;
    }

    public int batteryLife() {
        return batteryLife;
    }

    public void play() {
        happiness += 10;

        if (oil <= 20) {
            System.out.println("Please getOil Robotic Pet before Health declines");
        }
    }


    public void tick() {
        happiness -= 20;
        health -= 10;

    }


}
