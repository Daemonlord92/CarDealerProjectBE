package com.binary.carDealerApp.classCarDealerApp.services;

import com.binary.carDealerApp.classCarDealerApp.entities.Car;

import java.util.List;

public interface CarService {

    public List<Car> getAllCars();
    public Car createCar(Car car);
    public Car updateCar(Car car, Long id);
    public void deleteCarById(Long id);
    public Car getCarById(Long id);
}
