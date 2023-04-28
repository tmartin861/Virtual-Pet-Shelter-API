package com.wcci.virtualPetAPI;

import com.wcci.virtualPetAPI.entities.*;


import java.util.Scanner;

public class VirtualPetAmokApplication {
    public static void main(String[] args) {

        VirtualOrganicPet pet = new OrganicDog("Oscar", 10, 10, 10, 10, 10);
        VirtualOrganicPet pet3 = new OrganicCat("Raymond", 10, 10, 20, 15, 10);
        VirtualRoboticPet pet2 = new RoboticDog("Wrigley", 10, 10, 20, 10);
        VirtualRoboticPet pet4 = new RoboticCat("Whiskers", 10, 10, 10, 10);
        VirtualPetShelter myShelter = new VirtualPetShelter();
        myShelter.addOrganicPet(pet);
        myShelter.addOrganicPet(pet3);
        myShelter.addRoboticPet(pet2);
        myShelter.addRoboticPet(pet4);


        Scanner input = new Scanner(System.in);
        boolean run = true;

        System.out.println();
        System.out.println();
        myShelter.tickAllPets();
        myShelter.showOrganicPets();
        myShelter.showAllRoboticPets();
        System.out.println();
        System.out.println();
        System.out.println("Welcome to Playful pet looking for parents");

        String showMenu = """

                \t	Please choose an option:\s

                \t  1. Feed organic pet
                \t  2. Water organic pet
                \t  3. Clean the dog and cat cages.
                \t  4. Clean the litter box.
                \t  5. Walk the dogs.
                \t  6. Oil Robotic Pets.\s
                \t  7. Adopt a pet
                \t  8. Admit a pet
                \t  9. Play with a pet\s
                \t 10. Show pet in shelter
                \t 11. Quit""";


        int userChoice;
        // while (myOrganicShelter.hasPets()) {
        do {

            System.out.println(showMenu);
            userChoice = input.nextInt();
            switch (userChoice) {

                case 1 -> {
                    myShelter.tickAllPets();
                    myShelter.showOrganicPets();
                    myShelter.showAllRoboticPets();
                    myShelter.feedPets();
                    System.out.println();
                    System.out.println("You feed all organic pets");
                    System.out.println();

                }
                case 2 -> {
                    myShelter.tickAllPets();
                    myShelter.showOrganicPets();
                    myShelter.showAllRoboticPets();
                    myShelter.waterAllPets();
                    System.out.println();
                    System.out.println("You watered all organic pet");
                }

                case 3 -> {
                    myShelter.tickAllPets();
                    myShelter.showOrganicPets();
                    myShelter.showAllRoboticPets();
                    myShelter.cleanAllCages();
                    System.out.println();
                    System.out.println("Organic Dog and Cat cage cleaned");
                }

                case 4 -> {
                    myShelter.tickAllPets();
                    myShelter.showOrganicPets();
                    myShelter.showAllRoboticPets();
                    myShelter.emptyLitterBox();
                    System.out.println();
                    System.out.println("LitterBox Cleaned");
                    System.out.println();
                    System.out.println("Litter has been replaced in cats litter box.");
                }

                case 5 -> {
                    myShelter.tickAllPets();
                    myShelter.showOrganicPets();
                    myShelter.showAllRoboticPets();
                    myShelter.walkDogs();
                    System.out.println();
                    System.out.println("All dogs have been walked");
                    System.out.println();
                }

                case 6 -> {

                    myShelter.tickAllPets();
                    myShelter.showOrganicPets();
                    myShelter.showAllRoboticPets();
                    System.out.println();
                    System.out.println("All robotic pet parts have been oiled");
                    System.out.println();

                }

                case 7 -> {
                    myShelter.tickAllPets();
                    myShelter.showOrganicPets();
                    myShelter.showAllRoboticPets();
                    System.out.println();
                    System.out.println("Would you like to adopt one of the pet?");
                    String upForAdoptions = input.nextLine();
                    myShelter.removeOrganicPet(upForAdoptions);


                }

                case 8 -> {
                    myShelter.tickAllPets();
                    myShelter.showOrganicPets();
                    myShelter.showAllRoboticPets();
                    System.out.println(
                            "Do you have a: \n\t A. Organic Dog \n\t B. Organic Cat \n\t C. Robotic Dog \n\t D. Robotic Cat");
                    String petType = input.nextLine();
                    switch (petType.toUpperCase()) {

                        case "A" -> {
                            System.out.println("Name the Dog");
                            String organicDogName = input.nextLine();
                            VirtualOrganicPet newOrganicDog = new OrganicDog(organicDogName, 10, 10, 10, 10, 10);
                            myShelter.addOrganicPet(newOrganicDog);
                        }


                        case "B" -> {
                            System.out.println("Please petName the new cat: ");
                            String organicCatName = input.nextLine();
                            VirtualOrganicPet newOrganicCat = new OrganicCat(organicCatName, 10, 10, 0, 0, 0);
                            myShelter.addOrganicPet(newOrganicCat);
                        }

                        case "C" -> {
                            System.out.println("Please petName the new robotic dog: ");
                            String roboticDogName = input.nextLine();
                            VirtualRoboticPet newRoboticDog = new RoboticDog(roboticDogName, 10, 10, 0, 10);
                            myShelter.addRoboticPet(newRoboticDog);
                        }

                        case "D" -> {
                            System.out.println("Please petName the new robotic cat: ");
                            String roboticCatName = input.nextLine();
                            VirtualRoboticPet newRoboticCat = new RoboticCat(roboticCatName, 10, 10, 10, 10);
                            myShelter.addRoboticPet(newRoboticCat);
                        }
                    }

                }


                case 9 -> {
                    myShelter.tickAllPets();
                    myShelter.showOrganicPets();
                    myShelter.showAllRoboticPets();
                    System.out.println("Which pet would you like to play with?");
                    System.out.println();
                    String chosenPet = input.nextLine();
//                    VirtualPet petPlay = myShelter.getPetNamed(chosenPet);
//                    petPlay.play();
                    System.out.println(chosenPet + " had a great time!");
                }

                case 10 -> {
                    myShelter.tickAllPets();
                    System.out.println("These are the pet in the shelter: ");
                    myShelter.showOrganicPets();
                    myShelter.showAllRoboticPets();

                }


                case 11 -> {
                    System.out.println("See you next time!");
                    run = false;
                }
                default -> System.out.println("error, Try again.");
            }

            myShelter.tickAllPets();


        } while (run);

        input.close();


    }
}
