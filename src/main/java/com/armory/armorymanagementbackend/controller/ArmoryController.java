package com.armory.armorymanagementbackend.controller;

// A restfull controller, which has request mapping methods for REST-full requests.

import com.armory.armorymanagementbackend.model.Armory;
import com.armory.armorymanagementbackend.repository.ArmoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ArmoryController {
    @Autowired
    ArmoryRepository armoryRepository;

    @GetMapping("/armories")
    public ResponseEntity<List<Armory>> getAllArmories(@RequestParam(required = false) String type_title) {
        try {
            List<Armory> armories = new ArrayList<Armory>();

            if (type_title == null)
                armoryRepository.findAll().forEach(armories::add);
            else
//                armoryRepository.findByType_titleContaining(type_title).forEach(armories::add);

            if (armories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(armories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/armories/{id}")
    public ResponseEntity<Armory> getArmoryById(@PathVariable("id") long id) {
        Optional<Armory> armoryData = armoryRepository.findById(id);

        if (armoryData.isPresent()) {
            return new ResponseEntity<>(armoryData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/armories")
    public ResponseEntity<Armory> createArmory(@RequestBody Armory armory) {
        try {
            Armory _armory = armoryRepository
                    .save(new Armory(armory.getWeapon_category(), armory.getWeapon_specs(), armory.getAssigned_to(), armory.getAssigned_staff_badge_number(), armory.getBarcode(), armory.getIs_issued(), armory.getDate_issued(), armory.getDate_returned(), armory.getRfid(), armory.getLocation()));
            return new ResponseEntity<>(_armory, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/armories/{id}")
    public ResponseEntity<Armory> updateArmory(@PathVariable("id") long id, @RequestBody Armory armory) {
        Optional<Armory> armoryData = armoryRepository.findById(id);

        if (armoryData.isPresent()) {
            Armory _armory = armoryData.get();
            _armory.setWeapon_category(armory.getWeapon_category());
            _armory.setWeapon_specs(armory.getWeapon_specs());
            _armory.setAssigned_to(armory.getAssigned_to());
            _armory.setAssigned_staff_badge_number(armory.getAssigned_staff_badge_number());
            _armory.setBarcode(armory.getBarcode());
            _armory.setIs_issued(armory.getIs_issued());
            _armory.setDate_issued(armory.getDate_issued());
            _armory.setDate_returned(armory.getDate_returned());
            _armory.setDate_issued(armory.getDate_issued());
            _armory.setRfid(armory.getRfid());
            _armory.setLocation(armory.getLocation());


            return new ResponseEntity<>(armoryRepository.save(_armory), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/armories/{id}")
    public ResponseEntity<HttpStatus> deleteArmory(@PathVariable("id") long id) {
        try {
            armoryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/armories")
    public ResponseEntity<HttpStatus> deleteAllArmories() {
        try {
            armoryRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/armories/issued")
    public ResponseEntity<List<Armory>> findByIsIssued() {
        try {
            List<Armory> armories = armoryRepository.findByIsIssued(true);

            if (armories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(armories, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
