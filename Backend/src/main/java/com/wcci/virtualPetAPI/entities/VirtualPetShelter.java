package com.wcci.virtualPetAPI.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
public class VirtualPetShelter {

    @OneToMany()
    final Set<VirtualOrganicPet> myOrganicShelter = new HashSet<>();
    @OneToMany()
    final Set<VirtualRoboticPet> myRoboticShelter = new HashSet<>();
    @Id
    @GeneratedValue
    private Long id;

    public void addPet(VirtualPet virtualPet) {
        virtualPet.put(virtualPet.getPetName(), virtualPet);

    }

    public void addRoboticPet(VirtualRoboticPet adoptablePet) {
        String name = adoptablePet.getRoboticPetName();
        myRoboticShelter.add(adoptablePet);
    }

    public void removeRoboticPet(String adoptablePet) {
        myRoboticShelter.remove(adoptablePet);
    }


    public void addOrganicPet(VirtualOrganicPet adoptablePet) {
        String name = adoptablePet.getPetName();
        myOrganicShelter.add(adoptablePet);
    }

    public void removeOrganicPet(String adoptablePet) {
        myOrganicShelter.remove(adoptablePet);
    }


    public Collection<VirtualRoboticPet> roboticPets() {
        return myRoboticShelter;
    }

    public Collection<VirtualOrganicPet> OrganicPets() {
        return myOrganicShelter;
    }


    public void showOrganicPets() {
        for (VirtualOrganicPet pet : myOrganicShelter) {
            System.out.println("Name: " + pet.getPetName()
                    + "\t| Type: " + pet.getPetName()
                    + "\t| Health: " + pet.getHealth()
                    + "\t| Happiness: " + pet.getHappiness()
                    + "\t| Hunger: " + pet.getHunger()
                    + "\t| Thirst: " + pet.getThirst()
                    + "\t| Waste Level: " + pet.getWasteLevel()
            );

        }
    }

    public void showAllRoboticPets() {
        for (VirtualRoboticPet pet : myRoboticShelter) {
            System.out.println("Name: " + pet.getPetName()
                    + "\t| Type: " + pet.getRoboticPetName()
                    + "\t| Health: " + pet.getRoboticPetHealth()
                    + "\t| Happiness: " + pet.happiness()
                    + "\t| Oil Level: " + pet.getOil()
                    + "\t| Maintenance Level: " + pet.batteryLife()

            );
        }
    }


    public void getPetStats(VirtualPet adoptablePet) {
        for (VirtualOrganicPet pet : myOrganicShelter) {
            System.out.println("Name : " + pet.getPetName() + "\t| Health " + pet.getHealth()
                    + "\t| Happiness: " + pet.getHappiness());
        }
    }

    public String getPetNamed(String petName) {
        return petName;
    }


    public void playPets() {
        for (VirtualOrganicPet pet : myOrganicShelter) {
            pet.play();
        }
    }

    public void feedPets() {
        for (VirtualOrganicPet pet : myOrganicShelter) {
            pet.feed();

        }

    }

    public void tickAllPets() {

    }

    public void walkDogs() {
    }

    public void emptyLitterBox() {
    }

    public void cleanAllCages() {

    }

    public void waterAllPets() {
    }
}