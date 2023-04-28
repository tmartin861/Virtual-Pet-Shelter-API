package com.wcci.virtualPetAPI.restControllers;

import com.wcci.virtualPetAPI.entities.*;
import com.wcci.virtualPetAPI.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class PetController {
    // Define petRepository with VirtualPet
    final private PetRepository<VirtualPet> petRepository;

    // Use the generic VirtualPet in the constructor
    public PetController(final @Autowired PetRepository<VirtualPet> petRepository) {
        this.petRepository = petRepository;
    }

    @GetMapping("/pets")
    public Iterable<VirtualPet> getAllPets() {
        return petRepository.findAll();
    }

    @GetMapping("/pets/{petId}")
    public VirtualPet getSinglePet(@PathVariable String petId) {
        return petRepository.findById(petId).get();
    }

    @DeleteMapping("/pets/{petId}")
    public void adoptPet(@PathVariable String petId) {
        Optional<VirtualPet> optionalVirtualPet = petRepository.findById(petId);
        optionalVirtualPet.ifPresentOrElse((VirtualPet) -> {
                    petRepository.delete(VirtualPet);
                },
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot Adopt non existing pet" + petId);
                });
    }

    @PostMapping("/pets")
    public void admitPet(@RequestBody OrganicDog admitPet) {
        admitPet.getPetName();
        admitPet.getHappiness();
        admitPet.getHealth();
        admitPet.getThirst();
        admitPet.getWaste();
        petRepository.save(admitPet);
    }

    @PostMapping("/pets/{petId}/feed")
    public void feedPet(@PathVariable String petId) {
        // Retrieve the pet from the repository
        VirtualPet pet = petRepository.findById(petId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet not found"));

        // Check the actual type of the pet with instanceof
        if (pet instanceof OrganicPet) {
            ((OrganicPet) pet).feed();
        } else {
            // Throw an exception for unsupported pet types
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unsupported pet type");
        }

        // Save the pet back to the repository
        petRepository.save(pet);
    }

    @PostMapping("/pets/{petId}/play")
    public void playWithPet(@PathVariable String petId) {
        VirtualPet pet = petRepository.findById(petId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet not found"));
        if (pet instanceof OrganicPet) {
            ((OrganicPet) pet).play();
        } else if (pet instanceof RoboticPet) {
            ((RoboticPet) pet).play();
        } else {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unsupported pet type");
        }

        petRepository.save(pet);
    }

    @PostMapping("/pets/{petId}/walk")
    public void walkPet(@PathVariable String petId) {
        VirtualPet pet = petRepository.findById(petId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet not found"));
        if (pet instanceof OrganicPet) {
            ((OrganicPet) pet).walk();
        } else {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unsupported pet type");
        }

        petRepository.save(pet);

    }
}
