package com.wcci.virtualPetAPI.repositories;

import com.wcci.virtualPetAPI.entities.VirtualPet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository<V> extends CrudRepository <VirtualPet,String> {
}
