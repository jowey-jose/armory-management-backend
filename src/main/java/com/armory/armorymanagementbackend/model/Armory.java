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

    @Column(name = "type_title")
    private String type_title;

    @Column(name = "type_category")
    private String type_category;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "assigned_to")
    private String assigned_to;

    @Column(name = "rfid")
    private String rfid;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    @Column(name = "issued")
    private Boolean issued;

    @Column(name = "date_issued")
    private String date_issued;

    @Column(name = "created_at")
    private String created_at;

    // Default Constructor
    public Armory() {
    }

    // Constructor
    public Armory(String type_title, String type_category, String barcode, String assigned_to, String rfid, String location, String description, Boolean issued, String date_issued, String created_at) {
        this.type_title = type_title;
        this.type_category = type_category;
        this.barcode = barcode;
        this.assigned_to = assigned_to;
        this.rfid = rfid;
        this.location = location;
        this.description = description;
        this.issued = issued;
        this.date_issued = date_issued;
        this.created_at = created_at;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType_title() {
        return type_title;
    }

    public void setType_title(String type_title) {
        this.type_title = type_title;
    }

    public String getType_category() {
        return type_category;
    }

    public void setType_category(String type_category) {
        this.type_category = type_category;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIssued() {
        return issued;
    }

    public void setIssued(Boolean issued) {
        this.issued = issued;
    }

    public String getDate_issued() {
        return date_issued;
    }

    public void setDate_issued(String date_issued) {
        this.date_issued = date_issued;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    // Override Methods
    @Override
    public String toString() {
        return "Armory{" +
                "id=" + id +
                ", type_title='" + type_title + '\'' +
                ", type_category='" + type_category + '\'' +
                ", barcode='" + barcode + '\'' +
                ", assigned_to='" + assigned_to + '\'' +
                ", rfid='" + rfid + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", issued=" + issued +
                ", date_issued='" + date_issued + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
