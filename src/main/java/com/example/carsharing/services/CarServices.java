package com.example.carsharing.services;

import com.example.carsharing.models.Car;
import com.example.carsharing.repositories.CarRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CarServices {
    private final CarRepositories carRepositories;

    @Autowired
    public CarServices(CarRepositories carRepositories) {
        this.carRepositories = carRepositories;
    }

    public List<Car> findAll(){
        return carRepositories.findAll();
    }

    public Car findOneById(int id) {
        return carRepositories.findById(id).orElse(null);
    }

    @Transactional
    public void save(Car car) {
        carRepositories.save(car);
    }

    @Transactional
    public void update(int id, Car car) {
        car.setId(id);
        carRepositories.save(car);
    }

    @Transactional
    public void delete(int id){
        carRepositories.deleteById(id);
    }
}
