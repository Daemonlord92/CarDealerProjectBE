package com.binary.carDealerApp.classCarDealerApp.services;

import com.binary.carDealerApp.classCarDealerApp.entities.Car;
import com.binary.carDealerApp.classCarDealerApp.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car createCar(Car car) {
        return null;
    }

    @Override
    public Car updateCar(Car car, Long id) {
        return null;
    }

    @Override
    public void deleteCarById(Long id) {

    }

    @Override
    public Car getCarById(Long id) {
        return null;
    }
}
