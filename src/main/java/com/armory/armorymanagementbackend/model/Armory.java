package com.armory.armorymanagementbackend.model;

import javax.persistence.*;

// Data model class that corresponds to entity and table Armories.
@Entity
@Table(name = "armories")
public class Armory {
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto Increment field.
    @Column(name = "id", nullable = false) // Applies the Not Null constraint to this column.
    private Long id;

    @Column(name = "weapon_category")
    private String weapon_category;

    @Column(name = "weapon_specs")
    private String weapon_specs;

    @Column(name = "assigned_to")
    private String assigned_to;

    @Column(name = "assigned_staff_badge_number")
    private String assigned_staff_badge_number;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "isIssued")
    private Boolean isIssued;

    @Column(name = "date_issued")
    private String date_issued;

    @Column(name = "date_returned")
    private String date_returned;

    @Column(name = "rfid")
    private String rfid;

    @Column(name = "location")
    private String location;

    // Default Constructor
    public Armory() {
    }

    // Constructor
    public Armory(String weapon_category, String weapon_specs, String assigned_to, String assigned_staff_badge_number, String barcode, Boolean is_issued, String date_issued, String date_returned, String rfid, String location) {
        this.weapon_category = weapon_category;
        this.weapon_specs = weapon_specs;
        this.assigned_to = assigned_to;
        this.assigned_staff_badge_number = assigned_staff_badge_number;
        this.barcode = barcode;
        this.isIssued = isIssued;
        this.date_issued = date_issued;
        this.date_returned = date_returned;
        this.rfid = rfid;
        this.location = location;
    }

   // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeapon_category() {
        return weapon_category;
    }

    public void setWeapon_category(String weapon_category) {
        this.weapon_category = weapon_category;
    }

    public String getWeapon_specs() {
        return weapon_specs;
    }

    public void setWeapon_specs(String weapon_specs) {
        this.weapon_specs = weapon_specs;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
    }

    public String getAssigned_staff_badge_number() {
        return assigned_staff_badge_number;
    }

    public void setAssigned_staff_badge_number(String assigned_staff_badge_number) {
        this.assigned_staff_badge_number = assigned_staff_badge_number;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Boolean getIs_issued() {
        return isIssued;
    }

    public void setIs_issued(Boolean isIssued) {
        this.isIssued = isIssued;
    }

    public String getDate_issued() {
        return date_issued;
    }

    public void setDate_issued(String date_issued) {
        this.date_issued = date_issued;
    }

    public String getDate_returned() {
        return date_returned;
    }

    public void setDate_returned(String date_returned) {
        this.date_returned = date_returned;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    //override methods

    @Override
    public String toString() {
        return "Armory{" +
                "id=" + id +
                ", weapon_category='" + weapon_category + '\'' +
                ", weapon_specs='" + weapon_specs + '\'' +
                ", assigned_to='" + assigned_to + '\'' +
                ", assigned_staff_badge_number='" + assigned_staff_badge_number + '\'' +
                ", barcode='" + barcode + '\'' +
                ", isIssued=" + isIssued +
                ", date_issued='" + date_issued + '\'' +
                ", date_returned='" + date_returned + '\'' +
                ", rfid='" + rfid + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
