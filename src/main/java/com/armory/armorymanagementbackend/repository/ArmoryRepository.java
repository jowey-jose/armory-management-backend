package com.armory.armorymanagementbackend.repository;

import com.armory.armorymanagementbackend.model.Armory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Interface that extends JPA repository for CRUD methods and Custom Finder Methods.
// This interface will be Autowired in ArmoryController.
// Repository to interact with Armories from the database

@Repository
public interface ArmoryRepository extends JpaRepository<Armory, Long> {
    // Now we can use JpaRepository’s methods:
    // save(), findOne(), findById(), findAll(), count(), delete(), deleteById()… without implementing these methods.

    // Custom Finder Methods
    List<Armory> findByIsIssued(boolean isIssued);

}
