package com.armory.armorymanagementbackend.repository;

import com.armory.armorymanagementbackend.model.Armory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Interface that extends JPA repository for CRUD methods and Custom Finder Methods.
// This interface will be Autowired in ArmoryController.
// Repository to interact with Armories from the database

public interface ArmoryRepository extends JpaRepository<Armory, Long> {
    // Now we can use JpaRepository’s methods:
    // save(), findOne(), findById(), findAll(), count(), delete(), deleteById()… without implementing these methods.

    // Custom Finder Methods
    List<Armory> findByIssued(boolean issued);
//    List<Armory> findByType_titleContaining(String type_title); // Returns all Armory items which title input contains input title.
}
