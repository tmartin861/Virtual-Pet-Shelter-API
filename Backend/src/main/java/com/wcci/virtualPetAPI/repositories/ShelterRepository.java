package com.wcci.virtualPetAPI.repositories;

import com.wcci.virtualPetAPI.entities.VirtualPetShelter;
import org.springframework.data.repository.CrudRepository;

public interface ShelterRepository extends CrudRepository<VirtualPetShelter, String> {
}
