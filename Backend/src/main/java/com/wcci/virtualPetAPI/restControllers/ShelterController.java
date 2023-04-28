package com.wcci.virtualPetAPI.restControllers;

import com.wcci.virtualPetAPI.entities.VirtualPetShelter;
import com.wcci.virtualPetAPI.repositories.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShelterController {
    private final ShelterRepository shelterRepository;

    public ShelterController(final @Autowired ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    @GetMapping("/shelters")
    public Iterable<VirtualPetShelter> getAllShelters() {
        return shelterRepository.findAll();
    }

   @GetMapping("/shelters/{shelterId}")
    public VirtualPetShelter getPetShelter (@PathVariable String shelterId){
    return shelterRepository.findById(shelterId).get();
   }

    @PostMapping("/shelters")
    public VirtualPetShelter postShelter (final @RequestBody VirtualPetShelter shelter) {
        return shelterRepository.save(shelter);
    }


}




