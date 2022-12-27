package com.example.carsharing.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Car")
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "driver", referencedColumnName = "id")
    private User driver;

    @Column(name = "car_rental_time")
    private Timestamp car_rental_time;

    public Car() {}



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public Timestamp getCar_rental_time() {
        return car_rental_time;
    }

    public void setCar_rental_time(Timestamp car_rental_time) {
        this.car_rental_time = car_rental_time;
    }
}
