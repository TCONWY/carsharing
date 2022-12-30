package com.example.carsharing.services;

import com.example.carsharing.models.Car;
import com.example.carsharing.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CarServices {
    private final CarRepository carRepository;

    @Autowired
    public CarServices(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public Car findOneById(int id) {
        return carRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Car car) {
        carRepository.save(car);
    }

    @Transactional
    public void update(int id, Car car) {
        car.setId(id);
        carRepository.save(car);
    }

    @Transactional
    public void delete(int id){
        carRepository.deleteById(id);
    }
}
